package com.cognizant.loan.controller;

import com.cognizant.loan.model.Loan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);

    @GetMapping("/loans/{number}")
    public Loan getLoan(@PathVariable("number") String number) {
        LOGGER.info("START getLoan number: {}", number);
        Loan loan = new Loan(number, "car", 400000.0, 3258.0, 18);
        LOGGER.debug("Loan mock details: {}", loan);
        LOGGER.info("END getLoan");
        return loan;
    }
}
