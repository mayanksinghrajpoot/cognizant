package com.cognizant.designpatterns.builder;

public class Computer {
    // Required attributes
    private final String CPU;
    private final String RAM;
    private final String storage;

    // Optional attributes
    private final boolean isGraphicsCardEnabled;
    private final boolean isBluetoothEnabled;
    private final String OS;

    // Private constructor taking Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.OS = builder.OS;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isGraphicsCardEnabled() { return isGraphicsCardEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }
    public String getOS() { return OS; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + 
               ", GraphicsCard=" + isGraphicsCardEnabled + ", Bluetooth=" + isBluetoothEnabled + 
               ", OS=" + OS + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final String RAM;
        private final String storage;

        // Optional attributes with default values
        private boolean isGraphicsCardEnabled = false;
        private boolean isBluetoothEnabled = false;
        private String OS = "None";

        // Constructor for required attributes
        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        // Setter methods for optional attributes (returning Builder for chaining)
        public Builder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Builder setOS(String OS) {
            this.OS = OS;
            return this;
        }

        // build method returning instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }
}
