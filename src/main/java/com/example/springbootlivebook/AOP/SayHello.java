package com.example.springbootlivebook.AOP;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component

public class SayHello {

    @EventListener(ApplicationReadyEvent.class)
    public void sayHelloo() {
        System.out.println("Sayyyyyyyyyyyy Hello");
    }
}
