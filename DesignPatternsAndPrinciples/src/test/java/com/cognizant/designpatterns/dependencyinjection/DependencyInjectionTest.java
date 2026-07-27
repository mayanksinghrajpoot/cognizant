package com.cognizant.designpatterns.dependencyinjection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DependencyInjectionTest {

    @Test
    public void testDependencyInjection() {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        assertEquals("John Doe", service.getCustomerName(1));
        assertEquals("Jane Smith", service.getCustomerName(2));
        assertEquals("Customer Not Found", service.getCustomerName(99));
    }
}
