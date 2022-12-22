package com.example.springbootlivebook.proxy;

public class Start {
    public static void main(String[] args) {
        Service service = new Proxy();
        service.method();
    }
}
