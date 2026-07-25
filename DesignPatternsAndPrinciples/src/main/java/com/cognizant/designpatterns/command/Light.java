package com.cognizant.designpatterns.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Light {
    private static final Logger logger = LoggerFactory.getLogger(Light.class);
    private boolean on = false;

    public void turnOn() {
        on = true;
        logger.info("The light is ON.");
    }

    public void turnOff() {
        on = false;
        logger.info("The light is OFF.");
    }

    public boolean isOn() {
        return on;
    }
}
