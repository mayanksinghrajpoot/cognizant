package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrmLearnApplicationTests {

    @Autowired
    private CountryService countryService;

    @Test
    void contextLoads() {
        assertNotNull(countryService);
    }

    @Test
    void testCountrySearch() {
        List<Country> searchResult = countryService.searchCountriesByName("ou");
        assertFalse(searchResult.isEmpty());
        // Verify 'Bouvet Island' is fetched
        assertTrue(searchResult.stream().anyMatch(c -> c.getName().equals("Bouvet Island")));
    }
}
