package com.example.springjpatesting.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.MultiValueMap;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("prod")
public class EndToEndTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;


    @Test
    void postExampleTest() {
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorisation", "myKey");
        Vehicle vehicle = new Vehicle();
        vehicle.setBrand("Ford");
        vehicle.setColor("Red");
        vehicle.setBrand("Focus");

        HttpEntity httpEntity = new HttpEntity(vehicle, headers);
        ResponseEntity<Vehicle> vehicleResponseEntity = testRestTemplate.exchange("http://localhost:" + port + "/api/vehicles",
                HttpMethod.POST,
                httpEntity,
                Vehicle.class);

        ResponseEntity<Vehicle> vehicleResponseEntityActual = testRestTemplate.exchange("http://localhost:" + port + "/api/vehicles" + Objects.requireNonNull(vehicleResponseEntity.getBody()).getId(),
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Vehicle.class);




    }
}
