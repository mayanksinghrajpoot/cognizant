package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/india")
    public Country getCountryIndia() {
        LOGGER.info("START getCountryIndia");
        try {
            Country country = countryService.getCountry("IN");
            LOGGER.debug("India details: {}", country);
            LOGGER.info("END getCountryIndia");
            return country;
        } catch (CountryNotFoundException e) {
            LOGGER.error("India not found in configured countries list", e);
            return null;
        }
    }

    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("START getAllCountries");
        List<Country> list = countryService.getAllCountries();
        LOGGER.debug("All countries list: {}", list);
        LOGGER.info("END getAllCountries");
        return list;
    }

    @GetMapping("/{code}")
    public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException {
        LOGGER.info("START getCountry: {}", code);
        Country country = countryService.getCountry(code);
        LOGGER.debug("Country found: {}", country);
        LOGGER.info("END getCountry");
        return country;
    }

    @PostMapping
    public Country addCountry(@Valid @RequestBody Country country) {
        LOGGER.info("START addCountry: {}", country);
        countryService.addCountry(country);
        LOGGER.info("END addCountry");
        return country;
    }
}
