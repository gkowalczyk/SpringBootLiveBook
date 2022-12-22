package com.example.springbootlivebook;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpHeaders;
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

    @RequestMapping("/purchase")
    // strona 38 livebook, do stosowania nad klasą lub metodą. Domyślnie oprósz GET, mamy POST, PUT, DELETE, PATCH, OPTIONS, TRACE
    @GetMapping
    @ResponseBody
    public String purchase() {
        return "purchase method";
    }

    //Parametryzacja metod RESTowych :

    @GetMapping("/request-header-example")
    @ResponseBody
    public String requestHeaderExample(@RequestHeader("num") Long number) {  // przekazywanie przez nagłówek strona 41
        //System.out.println(number);
        return "delivered by RequestHeaders" + number;
    }

    @GetMapping("/request-param")  //przekazywanie przez parametr
    @ResponseBody
    public String requestParamExample(@RequestParam(name = "num") Long number) {
        return "delivered by RequestParam:" + number;
    }

    @RequestMapping("/get-path-variable/{id}")   //przekazywanie przez adres
    @ResponseBody
    public String patchVariableExample(@PathVariable(name = "id") Long id) {
        return "delivered by PathVariable:" + id;
    }

    @PostMapping("/get-request-body")   //przekazywanie przez ciało
    @ResponseBody
        public String requestBodyExample(@RequestBody String number) {
        return "delivered by RequestBody:" + number;
    }


}

