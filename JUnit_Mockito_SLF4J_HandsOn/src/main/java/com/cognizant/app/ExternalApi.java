package com.cognizant.app;

public interface ExternalApi {
    String getData();
    void logAccess(String username);
    String processData(String input);
}
