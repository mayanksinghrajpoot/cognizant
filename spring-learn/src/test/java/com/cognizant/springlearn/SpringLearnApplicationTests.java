package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        assertNotNull(mockMvc);
    }

    @Test
    void testGetHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!!"));
    }

    @Test
    void testGetCountriesWithoutToken() throws Exception {
        // Should return 403 Forbidden because endpoint is secured by default
        mockMvc.perform(get("/countries"))
                .andExpect(status().isForbidden());
    }

    @Test
    void testAuthenticationAndAccess() throws Exception {
        // Authenticate using basic auth for admin:pwd
        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:pwd".getBytes());

        // Extract token
        String jsonResponse = mockMvc.perform(post("/authenticate")
                        .header("Authorization", authHeader))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andReturn().getResponse().getContentAsString();

        String token = jsonResponse.substring(10, jsonResponse.length() - 2);

        // Fetch countries with bearer token
        mockMvc.perform(get("/countries")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("IN"))
                .andExpect(jsonPath("$[0].name").value("India"));
    }

    @Test
    void testGetCountryNotFound() throws Exception {
        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:pwd".getBytes());
        String jsonResponse = mockMvc.perform(post("/authenticate")
                        .header("Authorization", authHeader))
                .andReturn().getResponse().getContentAsString();
        String token = jsonResponse.substring(10, jsonResponse.length() - 2);

        mockMvc.perform(get("/countries/ZZ")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isNotFound());
    }

    @Test
    void testAddCountryValidation() throws Exception {
        String authHeader = "Basic " + Base64.getEncoder().encodeToString("admin:pwd".getBytes());
        String jsonResponse = mockMvc.perform(post("/authenticate")
                        .header("Authorization", authHeader))
                .andReturn().getResponse().getContentAsString();
        String token = jsonResponse.substring(10, jsonResponse.length() - 2);

        // Invalid code (length 3 instead of 2)
        String invalidCountryJson = "{\"code\":\"IND\",\"name\":\"India\"}";

        mockMvc.perform(post("/countries")
                        .header("Authorization", "Bearer " + token)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidCountryJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").exists());
    }
}
