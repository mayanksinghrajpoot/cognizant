package com.cognizant.designpatterns.command;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommandTest {

    @Test
    public void testLightCommandExecution() {
        Light livingRoomLight = new Light();
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Initially light is off
        assertFalse(livingRoomLight.isOn());

        // Press button to turn on
        remote.setCommand(lightOn);
        remote.pressButton();
        assertTrue(livingRoomLight.isOn());

        // Press button to turn off
        remote.setCommand(lightOff);
        remote.pressButton();
        assertFalse(livingRoomLight.isOn());
    }
}
