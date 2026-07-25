package com.cognizant.designpatterns.decorator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecoratorTest {

    @Test
    public void testEmailAndSMSNotification() {
        Notifier emailNotifier = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);

        assertDoesNotThrow(() -> emailAndSMS.send("System alert level 1"));
    }

    @Test
    public void testAllChannelsNotification() {
        Notifier emailNotifier = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifierDecorator(emailNotifier);
        Notifier allChannels = new SlackNotifierDecorator(emailAndSMS);

        assertDoesNotThrow(() -> allChannels.send("Critical system failure"));
    }
}
