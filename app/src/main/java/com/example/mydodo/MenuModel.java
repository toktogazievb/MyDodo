package com.example.mydodo;

import java.io.Serializable;

public class MenuModel implements Serializable {
    private String image, name;

    public MenuModel(String image, String name) {
        this.image = image;
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
