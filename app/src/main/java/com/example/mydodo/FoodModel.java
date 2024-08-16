package com.example.mydodo;

import java.io.Serializable;

public class FoodModel implements Serializable {
    private String image, name, description, price, type;

    public FoodModel(String image, String name, String description, String price, String type) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price + "$";
    }

    public String getType() {
        return type;
    }
}