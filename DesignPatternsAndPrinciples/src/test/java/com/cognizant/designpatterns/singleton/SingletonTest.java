package com.cognizant.designpatterns.singleton;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void testSingletonInstanceIdentical() {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        assertNotNull(logger1, "Logger instance should not be null");
        assertSame(logger1, logger2, "Multiple calls to getInstance() should return the exact same instance");
    }
}
