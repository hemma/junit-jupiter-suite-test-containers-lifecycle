package dev.bothin.testcontainers.java;

import dev.bothin.testcontainers.TestContainerConfigurationClass;
import dev.bothin.testcontainers.TestContainerLifecycleExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestContainerLifecycleExtension.class)
@TestContainerConfigurationClass(ContainerConfiguration.class)
class Test2 {
    @BeforeEach
    void setUp() {
        System.out.println("Java Test2 before");
    }

    @Test
    void when1() {
        System.out.println("Java Test2 when 1");
        assertEquals(1, 1);
    }


    @Test
    void when2() {
        System.out.println("Java Test2 when 2");
        assertEquals(2, 2);
    }
}
