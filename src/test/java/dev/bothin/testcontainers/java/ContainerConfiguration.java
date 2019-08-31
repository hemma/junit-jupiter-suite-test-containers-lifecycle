package dev.bothin.testcontainers.java;

import dev.bothin.testcontainers.TestContainerConfiguration;
import org.testcontainers.containers.wait.strategy.Wait;

public class ContainerConfiguration implements TestContainerConfiguration {

    private MqttContainer mqttContainer;

    public ContainerConfiguration() {
        mqttContainer = new MqttContainer("eclipse-mosquitto");
        mqttContainer.withExposedPorts(1883).waitingFor(Wait.forLogMessage(".*Config loaded from.*", 1));
    }

    @Override
    public void startAll() {
        mqttContainer.start();
    }

    @Override
    public void afterStart() {
        System.setProperty("MQTT_HOST", mqttContainer.getContainerIpAddress());
        System.setProperty("MQTT_PORT", mqttContainer.getMappedPort(1883).toString());
    }

    @Override
    public void stopAll() {
        mqttContainer.stop();
    }
}

