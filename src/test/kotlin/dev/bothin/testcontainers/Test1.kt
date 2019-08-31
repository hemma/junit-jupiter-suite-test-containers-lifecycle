package dev.bothin.testcontainers

import com.github.dockerjava.core.DockerClientBuilder
import io.kotlintest.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.testcontainers.shaded.org.apache.commons.lang.SystemUtils


@ExtendWith(TestContainerLifecycleExtension::class)
@TestContainerConfigurationClass(ContainerConfiguration::class)
class Test1 {

    @BeforeEach
    fun setUp() {
        println("Test1 before")
    }

    @Test
    fun `when 1`() {
        println("Test1 when 1")
        println(System.getProperty("MQTT_HOST"))
        println(System.getProperty("MQTT_PORT"))
        1 shouldBe 1
    }


    @Test
    fun `when 2`() {
        println("Test1 when 2")
        2 shouldBe 2
    }

}