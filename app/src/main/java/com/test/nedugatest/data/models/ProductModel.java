package com.test.nedugatest.data.models;

import com.google.gson.annotations.SerializedName;

public class ProductModel {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("price")
    private double price;
    @SerializedName("description")
    private String description;
    @SerializedName("category")
    private String category;
    @SerializedName("image")
    private String image;
    @SerializedName("rating")
    private RatingModel rating;

    public ProductModel(int id, String title, double price, String description, String category, String image, RatingModel rating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RatingModel getRating() {
        return rating;
    }

    public void setRating(RatingModel rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }
}
