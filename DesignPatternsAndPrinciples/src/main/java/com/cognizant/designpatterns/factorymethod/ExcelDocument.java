package com.cognizant.designpatterns.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelDocument implements Document {
    private static final Logger logger = LoggerFactory.getLogger(ExcelDocument.class);

    @Override
    public void open() {
        logger.info("Opening Excel document.");
    }

    @Override
    public void close() {
        logger.info("Closing Excel document.");
    }
}
