package com.example.springbootlivebook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShoppingCardTest {
    @Autowired
    ShoppingCard shoppingCard;
    @Test
    void ShoppingCardTest() {

      shoppingCard.addProductToCard(new Product(1, "test"));
        System.out.println(shoppingCard);
    }

}
