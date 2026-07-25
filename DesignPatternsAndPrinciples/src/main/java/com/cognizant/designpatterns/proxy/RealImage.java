package com.cognizant.designpatterns.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RealImage implements Image {
    private static final Logger logger = LoggerFactory.getLogger(RealImage.class);
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        logger.info("Loading image: {} from remote server...", filename);
        try {
            Thread.sleep(1000); // Simulate network latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        logger.info("Image: {} loaded successfully.", filename);
    }

    @Override
    public void display() {
        logger.info("Displaying image: {}", filename);
    }
}
