package com.emeraldhieu.stream;

public class Product {
    private final int price;
    private final String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
