package com.cognizant.designpatterns.mvc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MVCTest {

    @Test
    public void testMVCPattern() {
        // Create model
        Student student = new Student();
        student.setId("S101");
        student.setName("Alice");
        student.setGrade("A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Verify initial state
        assertEquals("Alice", controller.getStudentName());
        assertEquals("S101", controller.getStudentId());
        assertEquals("A", controller.getStudentGrade());

        // Update model via controller
        controller.setStudentName("Bob");
        controller.setStudentGrade("A+");

        assertEquals("Bob", controller.getStudentName());
        assertEquals("A+", controller.getStudentGrade());

        // Display updated view
        assertDoesNotThrow(controller::updateView);
    }
}
