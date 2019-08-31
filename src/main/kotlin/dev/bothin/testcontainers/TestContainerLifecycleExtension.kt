package dev.bothin.testcontainers

import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

private const val CLOSE_SUFFIX = "dev.bothin.testcontainers.lifecycle.close"

class TestContainerLifecycleExtension : BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private val instances = mutableMapOf<String, TestContainerConfiguration>()

    override fun beforeAll(context: ExtensionContext) {
        val globalStore = context.root.getStore(GLOBAL)
        val testClass = context.testClass.get()
        val testContainerConfiguration =
            testClass.getAnnotation(TestContainerConfigurationClass::class.java)?.value
                ?: testClass.superclass.getAnnotation(TestContainerConfigurationClass::class.java)?.value
        checkNotNull(testContainerConfiguration)
        val qualifiedName = testContainerConfiguration.qualifiedName
        checkNotNull(qualifiedName)

        val storeCode = "$CLOSE_SUFFIX.$qualifiedName"
        if (globalStore.get(storeCode) == null) {
            globalStore.put(storeCode, this)
            val instance =
                testContainerConfiguration.primaryConstructor?.call() ?: testContainerConfiguration.java.newInstance()

            instance.startAll()
            instance.afterStart()

            instances[qualifiedName] = instance
        } else {
            instances[qualifiedName]?.afterStart()
        }
    }

    override fun close() {
        instances.values.forEach {
            it.stopAll()
        }
    }
}

@Target(AnnotationTarget.CLASS)
annotation class TestContainerConfigurationClass(val value: KClass<out TestContainerConfiguration>)