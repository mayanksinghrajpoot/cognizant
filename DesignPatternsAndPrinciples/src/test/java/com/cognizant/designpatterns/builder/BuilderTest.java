package com.cognizant.designpatterns.builder;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    @Test
    public void testBasicComputerBuild() {
        Computer basicComputer = new Computer.Builder("Intel i3", "8GB", "256GB SSD").build();

        assertEquals("Intel i3", basicComputer.getCPU());
        assertEquals("8GB", basicComputer.getRAM());
        assertEquals("256GB SSD", basicComputer.getStorage());
        assertFalse(basicComputer.isGraphicsCardEnabled());
        assertFalse(basicComputer.isBluetoothEnabled());
        assertEquals("None", basicComputer.getOS());
    }

    @Test
    public void testGamingComputerBuild() {
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB", "2TB NVMe")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .setOS("Windows 11 Pro")
                .build();

        assertEquals("Intel i9", gamingComputer.getCPU());
        assertEquals("32GB", gamingComputer.getRAM());
        assertEquals("2TB NVMe", gamingComputer.getStorage());
        assertTrue(gamingComputer.isGraphicsCardEnabled());
        assertTrue(gamingComputer.isBluetoothEnabled());
        assertEquals("Windows 11 Pro", gamingComputer.getOS());
    }
}
