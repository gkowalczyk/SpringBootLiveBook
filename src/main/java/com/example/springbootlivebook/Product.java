package com.example.springbootlivebook;

public class Product {

    private final int amouunt;
    private final String name;

    public Product(int amouunt, String name) {
        this.amouunt = amouunt;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "amouunt=" + amouunt +
                ", name='" + name + '\'' +
                '}';
    }
}
