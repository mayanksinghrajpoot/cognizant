package com.cognizant.app;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void logAccess(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        externalApi.logAccess(username);
    }

    public String getFormattedData(String input) {
        String data = externalApi.processData(input);
        return "Processed: " + data;
    }
}
