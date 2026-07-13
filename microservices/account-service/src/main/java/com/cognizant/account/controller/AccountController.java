package com.cognizant.account.controller;

import com.cognizant.account.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @GetMapping("/accounts/{number}")
    public Account getAccount(@PathVariable("number") String number) {
        LOGGER.info("START getAccount number: {}", number);
        Account account = new Account(number, "savings", 234343.0);
        LOGGER.debug("Account mock details: {}", account);
        LOGGER.info("END getAccount");
        return account;
    }
}
