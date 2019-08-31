package dev.bothin.testcontainers.java;

import org.testcontainers.containers.GenericContainer;

class MqttContainer extends GenericContainer {

    public MqttContainer(String imageName) {
        super(imageName);
    }
}
