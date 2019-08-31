package dev.bothin.testcontainers

interface TestContainerConfiguration {

    fun startAll()

    fun afterStart()

    fun stopAll()
}