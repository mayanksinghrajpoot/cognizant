package com.cognizant.designpatterns.singleton;

public class Logger {
    private static final org.slf4j.Logger slf4jLogger = org.slf4j.LoggerFactory.getLogger(Logger.class);

    // Private constructor to prevent instantiation
    private Logger() {
        slf4jLogger.info("Logger instance initialized.");
    }

    // Bill Pugh Singleton Implementation
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    // Public static method to get instance
    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    // Logger method to simulate logging
    public void log(String message) {
        slf4jLogger.info("[LOG]: {}", message);
    }
}
