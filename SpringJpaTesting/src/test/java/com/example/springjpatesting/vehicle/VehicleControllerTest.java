package com.example.springjpatesting.vehicle;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("prod")
class VehicleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    Flyway flyway;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testGetVehicles() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();

        Vehicle[] vehicles = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Vehicle[].class);
        Assertions.assertEquals("Alfa Romeo", vehicles[0].getBrand());
    }

    @Test
    void testVehiclesShouldFailWithStatus404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles/7"))
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @Test
    void postDelete() throws Exception {

        String vehicle = "{\n" +
                " \"brand\" : \"bmw\", \n" +
                " \"model\" : \"fast\", \n" +
                " \"color\" : \"black\" \n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/vehicles/")
                        .contentType(MediaType.APPLICATION_JSON).content(vehicle))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    void testVehiclesShouldPass() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/vehicles/1"))
                .andExpect(MockMvcResultMatchers.status().is(200));
    }

    @AfterEach
    void cleanUp() {
        flyway.clean();
        flyway.migrate();
    }








}