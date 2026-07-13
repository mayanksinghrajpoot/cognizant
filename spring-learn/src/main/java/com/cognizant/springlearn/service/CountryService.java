package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {

    private final List<Country> countries = new ArrayList<>();

    public CountryService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
        @SuppressWarnings("unchecked")
        List<Country> list = context.getBean("countryList", ArrayList.class);
        countries.addAll(list);
    }

    public List<Country> getAllCountries() {
        return countries;
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new CountryNotFoundException("Country not found for code: " + code));
    }

    public void addCountry(Country country) {
        // Check if already exists
        boolean exists = countries.stream().anyMatch(c -> c.getCode().equalsIgnoreCase(country.getCode()));
        if (exists) {
            throw new RuntimeException("Country with code " + country.getCode() + " already exists!");
        }
        countries.add(country);
    }
}
