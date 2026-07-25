package com.cognizant.designpatterns.proxy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {

    @Test
    public void testProxyLazyLoadingAndCaching() {
        Image image = new ProxyImage("photo.jpg");

        long start = System.currentTimeMillis();
        // First display: should load and display
        image.display();
        long loadDuration = System.currentTimeMillis() - start;

        // Since it sleeps for 1s, duration should be >= 1000ms
        assertTrue(loadDuration >= 1000, "First display should take time to load from server");

        start = System.currentTimeMillis();
        // Second display: should fetch from cache instantly
        image.display();
        long cacheDuration = System.currentTimeMillis() - start;

        // Since it is cached, it should take less than 100ms
        assertTrue(cacheDuration < 100, "Second display should be instant (cached)");
    }
}
