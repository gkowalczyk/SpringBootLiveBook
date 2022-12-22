package com.example.springbootlivebook;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("/v1")
public class RestClient {

    @GetMapping("/rest")
public String callGet() {
            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> exchange = restTemplate.exchange("https://livebooks.pl/materials/v1//hello-api?name=Przemek",
                    HttpMethod.GET,
                    HttpEntity.EMPTY,
                    String.class);
            return exchange.getBody();
        }

        @PostMapping("/send")
        public String callPost() {
        RestTemplate restTemplate = new RestTemplate();

            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("key", "value");
            HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(map, new HttpHeaders());
            ResponseEntity<String> exchange = restTemplate.exchange("https://livebooks.pl/materials/v1//hello-api",
                    HttpMethod.POST,
                    HttpEntity.EMPTY,
                    String.class);
             return exchange.getBody();
        }
    }

