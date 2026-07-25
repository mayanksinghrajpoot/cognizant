package com.cognizant.designpatterns.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WordDocument implements Document {
    private static final Logger logger = LoggerFactory.getLogger(WordDocument.class);

    @Override
    public void open() {
        logger.info("Opening Word document.");
    }

    @Override
    public void close() {
        logger.info("Closing Word document.");
    }
}
