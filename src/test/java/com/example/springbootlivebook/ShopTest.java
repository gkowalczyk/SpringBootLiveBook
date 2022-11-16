package com.example.springbootlivebook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShopTest {
    @Autowired
    Shop shop;

    @Test
    void ShopTest() {
        shop.purchase();
    }
}
