package dev.bothin.testcontainers

import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait


class ContainerConfiguration : TestContainerConfiguration {

    private val mqttContainer = MqttContainer("eclipse-mosquitto")
        .withExposedPorts(1883)
        .waitingFor(Wait.forLogMessage(".*Config loaded from.*", 1))

    override fun startAll() {
        mqttContainer.start()
    }

    override fun afterStart() {
        System.setProperty("MQTT_HOST", mqttContainer.containerIpAddress)
        System.setProperty("MQTT_PORT", mqttContainer.getMappedPort(1883).toString())
    }

    override fun stopAll() {
        mqttContainer.stop()
    }

}

open class KGenericContainer(imageName: String) : GenericContainer<KGenericContainer>(imageName)

class MqttContainer(imageName: String) : KGenericContainer(imageName)