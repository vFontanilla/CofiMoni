package com.example.cofiproject.model;

public class ItemModel {
//    private int imageResource;
    private String name;
    private double price;

    // Constructor to initialize all fields
    public ItemModel(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter and Setter for imageResource
//    public int getImageResource() {
//        return imageResource;
//    }

//    public void setImageResource(int imageResource) {
//        this.imageResource = imageResource;
//    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
