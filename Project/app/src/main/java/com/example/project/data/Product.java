package com.example.project.data;

public class Product {
    private String id;
    private String name;
    private String description;
    private String classify;
    private double price;
    private String imgLink;

    public Product() {
    }

    public Product(String id, String name, String description, String classify, double price, String imgLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classify = classify;
        this.price = price;
        this.imgLink = imgLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
