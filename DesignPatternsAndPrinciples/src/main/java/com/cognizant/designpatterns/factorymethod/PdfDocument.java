package com.cognizant.designpatterns.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PdfDocument implements Document {
    private static final Logger logger = LoggerFactory.getLogger(PdfDocument.class);

    @Override
    public void open() {
        logger.info("Opening PDF document.");
    }

    @Override
    public void close() {
        logger.info("Closing PDF document.");
    }
}
