package com.cognizant.designpatterns.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentView {
    private static final Logger logger = LoggerFactory.getLogger(StudentView.class);

    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        logger.info("--- Student Details ---");
        logger.info("ID: {}", studentId);
        logger.info("Name: {}", studentName);
        logger.info("Grade: {}", studentGrade);
    }
}
