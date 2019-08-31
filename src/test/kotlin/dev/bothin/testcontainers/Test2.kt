package dev.bothin.testcontainers

import io.kotlintest.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestContainerLifecycleExtension::class)
@TestContainerConfigurationClass(ContainerConfiguration::class)
class Test2 {

    @BeforeEach
    fun setUp() {
        println("Test2 before")
    }

    @Test
    fun `when 1`() {
        println("Test2 when 1")
        1 shouldBe 1
    }


    @Test
    fun `when 2`() {
        println("Test2 when 2")
        2 shouldBe 2
    }
}