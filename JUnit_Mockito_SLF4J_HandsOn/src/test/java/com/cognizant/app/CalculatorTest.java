package com.cognizant.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Arrange
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void testAdd() {
        // Act
        int result = calculator.add(10, 20);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testSubtract() {
        // Act
        int result = calculator.subtract(50, 20);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testMultiply() {
        // Act
        int result = calculator.multiply(5, 6);

        // Assert
        assertEquals(30, result);
    }

    @Test
    public void testDivide() {
        // Act
        double result = calculator.divide(100, 4);

        // Assert
        assertEquals(25.0, result);
    }

    @Test
    public void testDivideByZeroThrowsException() {
        // Assert exception
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
    }
}
