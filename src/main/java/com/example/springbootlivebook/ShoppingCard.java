package com.example.springbootlivebook;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCard {

    private final List<Product> productList;

    public ShoppingCard() {
        this.productList = new ArrayList<>();
    }

    public void addProductToCard(Product product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "productList=" + productList +
                '}';
    }
}
