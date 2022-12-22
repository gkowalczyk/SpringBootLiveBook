package com.example.springbootlivebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Shop {

    @Autowired        // wstrzykiwanie przez pole
    private ShoppingCard shoppingCard;

    @Autowired          // przez setter
    public void setShoppingCard(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }
    @Autowired     // przez konstruktor
    public Shop(ShoppingCard shoppingCard) {
        this.shoppingCard = shoppingCard;
    }

     @EventListener(ApplicationReadyEvent.class)
    public void purchase() {
        shoppingCard.addProductToCard(new Product(1, "Milk"));
        shoppingCard.addProductToCard(new Product(1, "Tea"));
        shoppingCard.addProductToCard(new Product(1, "Bread"));
        System.out.println(shoppingCard);

    }
}
