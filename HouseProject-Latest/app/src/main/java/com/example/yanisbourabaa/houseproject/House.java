package com.example.yanisbourabaa.houseproject;

import java.io.Serializable;

/**
 * Created by yanisbourabaa on 17/02/2017.
 */
public class House implements Serializable {

    private String imageUrl;
    private String address;
    private int rating;
    private Double price;
    private String highlight;
    private String[] imageURLs;

    public House(String imageUrl, String address, int rating, Double price, String highlight, String[] imageURLs) {
        this.imageUrl = imageUrl;
        this.address = address;
        this.rating = rating;
        this.price = price;
        this.highlight = highlight;
        this.imageURLs = imageURLs;
    }


    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }

    public String[] getImageURLs () { return imageURLs; }

    public void setImageURLs (String[] iURLs) { this.imageURLs = iURLs; }
}
