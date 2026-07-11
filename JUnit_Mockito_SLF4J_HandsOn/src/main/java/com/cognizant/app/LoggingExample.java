package com.cognizant.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        runLoggingDemo("DefaultUser");
    }

    public static void runLoggingDemo(String username) {
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        
        // Parameterized logging
        logger.info("User {} accessed the LoggingExample application.", username);
        
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("Exception occurred during operation: ", e);
        }
    }
}
