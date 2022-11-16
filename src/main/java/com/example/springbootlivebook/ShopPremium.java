package com.example.springbootlivebook;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
@RequestMapping("/api")
@Profile("Premium")
public class ShopPremium {


    @EventListener(ApplicationReadyEvent.class)
    public void get() {
        System.out.println("Premium Shop");
    }

    @RequestMapping("/purchase")  // strona 38 livebook, do stosowania nad klasą lub metodą. Domyślnie oprósz GET, mamy POST, PUT, DELETE, PATCH, OPTIONS, TRACE
    @GetMapping
    @ResponseBody
    public String purchase() {
        return "purchase method";
    }

    //Parametryzacja metod RESTowych :

   @GetMapping("/request-header-example")
    public String requestHeaderExample(@RequestHeader("number") Long number) {  // przekazywanie przez nagłówek strona 41
       System.out.println(number);
       return "delivered by RequestHeaders" + number;
   }


    }


