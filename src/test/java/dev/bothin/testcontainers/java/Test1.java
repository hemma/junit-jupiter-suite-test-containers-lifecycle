package dev.bothin.testcontainers.java;

import dev.bothin.testcontainers.TestContainerConfigurationClass;
import dev.bothin.testcontainers.TestContainerLifecycleExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestContainerLifecycleExtension.class)
@TestContainerConfigurationClass(ContainerConfiguration.class)
public class Test1 {
    @BeforeEach
    public void setUp() {
        System.out.println("Java Test1 before");
    }

    @Test
    public void when1() {
        System.out.println("Java Test1 when 1");
        System.out.println(System.getProperty("MQTT_HOST"));
        System.out.println(System.getProperty("MQTT_PORT"));
        assertEquals(1, 1);
    }


    @Test
    public void when2() {
        System.out.println("Java Test1 when 2");
        assertEquals(2, 2);
    }
}
