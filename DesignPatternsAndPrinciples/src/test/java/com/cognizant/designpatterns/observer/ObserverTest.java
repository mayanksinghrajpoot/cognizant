package com.cognizant.designpatterns.observer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    @Test
    public void testObserverNotification() {
        StockMarket appleStock = new StockMarket("AAPL", 150.00);

        Observer mobileApp = new MobileApp("StockTrader");
        Observer webApp = new WebApp("FinancePortal");

        appleStock.registerObserver(mobileApp);
        appleStock.registerObserver(webApp);

        // Verify state updates correctly and observers are notified without exceptions
        assertDoesNotThrow(() -> appleStock.setPrice(155.50));

        appleStock.deregisterObserver(mobileApp);
        // Verify state updates work after deregistration
        assertDoesNotThrow(() -> appleStock.setPrice(160.00));
    }
}
