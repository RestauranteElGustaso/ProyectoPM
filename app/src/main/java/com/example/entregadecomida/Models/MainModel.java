package com.example.entregadecomida.Models;

public class MainModel {
    int image;
    String name, price, description, quantity;

    public MainModel(int image, String name, String price, String description, String quantity) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity(){return quantity;}

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
