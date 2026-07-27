package com.cognizant.designpatterns;

import com.cognizant.designpatterns.singleton.Logger;
import com.cognizant.designpatterns.factorymethod.*;
import com.cognizant.designpatterns.builder.Computer;
import com.cognizant.designpatterns.adapter.*;
import com.cognizant.designpatterns.decorator.*;
import com.cognizant.designpatterns.proxy.*;
import com.cognizant.designpatterns.observer.*;
import com.cognizant.designpatterns.strategy.*;
import com.cognizant.designpatterns.command.*;
import com.cognizant.designpatterns.mvc.*;
import com.cognizant.designpatterns.dependencyinjection.*;

public class Main {
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("=========================================");
        logger.info("Starting Design Patterns & Principles Demos");
        logger.info("=========================================");

        // 1. Singleton Pattern
        logger.info("\n--- 1. Singleton Pattern Demo ---");
        Logger logger1 = Logger.getInstance();
        logger1.log("This is a log message from the Singleton logger.");
        Logger logger2 = Logger.getInstance();
        logger.info("Are both logger instances identical? {}", (logger1 == logger2));

        // 2. Factory Method Pattern
        logger.info("\n--- 2. Factory Method Pattern Demo ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.close();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.close();

        // 3. Builder Pattern
        logger.info("\n--- 3. Builder Pattern Demo ---");
        Computer gamingPC = new Computer.Builder("AMD Ryzen 9", "64GB", "4TB NVMe")
                .setGraphicsCardEnabled(true)
                .setBluetoothEnabled(true)
                .setOS("Windows 11")
                .build();
        logger.info("Built Gaming PC: {}", gamingPC);

        // 4. Adapter Pattern
        logger.info("\n--- 4. Adapter Pattern Demo ---");
        PaymentProcessor paypal = new PaypalAdapter(new PaypalGateway());
        paypal.processPayment(120.0);
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(350.5);

        // 5. Decorator Pattern
        logger.info("\n--- 5. Decorator Pattern Demo ---");
        Notifier simpleEmail = new EmailNotifier();
        Notifier emailAndSMS = new SMSNotifierDecorator(simpleEmail);
        Notifier emailSMSSlack = new SlackNotifierDecorator(emailAndSMS);
        emailSMSSlack.send("Critical System Update Required!");

        // 6. Proxy Pattern
        logger.info("\n--- 6. Proxy Pattern Demo ---");
        Image proxyImage = new ProxyImage("design_spec.png");
        logger.info("First call to display (should trigger load from remote server):");
        proxyImage.display();
        logger.info("Second call to display (should fetch from cache instantly):");
        proxyImage.display();

        // 7. Observer Pattern
        logger.info("\n--- 7. Observer Pattern Demo ---");
        StockMarket techIndex = new StockMarket("TECH-INDEX", 2800.0);
        Observer mobileClient = new MobileApp("Client1-Mobile");
        Observer webClient = new WebApp("Client1-Web");
        techIndex.registerObserver(mobileClient);
        techIndex.registerObserver(webClient);
        logger.info("Updating stock market index price...");
        techIndex.setPrice(2845.60);

        // 8. Strategy Pattern
        logger.info("\n--- 8. Strategy Pattern Demo ---");
        PaymentContext strategyContext = new PaymentContext();
        strategyContext.setPaymentStrategy(new CreditCardPayment("4321-8765-1092", "Jane Smith"));
        strategyContext.executePayment(89.99);
        strategyContext.setPaymentStrategy(new PayPalPayment("jane.smith@email.com"));
        strategyContext.executePayment(45.50);

        // 9. Command Pattern
        logger.info("\n--- 9. Command Pattern Demo ---");
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();

        // 10. MVC Pattern
        logger.info("\n--- 10. MVC Pattern Demo ---");
        Student studentModel = new Student();
        studentModel.setId("COGN-990");
        studentModel.setName("Mayank");
        studentModel.setGrade("A+");
        StudentView studentView = new StudentView();
        StudentController controller = new StudentController(studentModel, studentView);
        controller.updateView();
        controller.setStudentGrade("O (Outstanding)");
        logger.info("Updating grade via controller...");
        controller.updateView();

        // 11. Dependency Injection Pattern
        logger.info("\n--- 11. Dependency Injection Demo ---");
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repo);
        logger.info("Found customer: {}", customerService.getCustomerName(1));

        logger.info("=========================================");
        logger.info("Design Patterns & Principles Demos Completed");
        logger.info("=========================================");
    }
}
