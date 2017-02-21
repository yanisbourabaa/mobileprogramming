package com.example.yanisbourabaa.secondclass.model;

/**
 * Created by yanisbourabaa on 10/02/2017.
 */
public class Product {

    private int id;
    private String image;
    private String name;
    private int quantity = 0;
    private Float price;
    private String recipeUrl;
    private int rate;

    public Product(int id, String name, String image, Float price, String recipeUrl, int rate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.recipeUrl = recipeUrl;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public Float getPrice() {
        return price;
    }

    public String getRecipeUrl() {
        return recipeUrl;
    }

    public void setRecipeUrl(String recipeUrl) {
        this.recipeUrl = recipeUrl;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
