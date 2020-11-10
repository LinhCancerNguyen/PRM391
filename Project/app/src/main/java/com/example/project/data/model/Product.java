package com.example.project.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

import javax.annotation.Nonnull;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private String classify;
    @ColumnInfo
    private long price;
    @ColumnInfo
    private String imgLink;

    public Product() {
    }

    public Product(int id, String name, String description, String classify, long price, String imgLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.classify = classify;
        this.price = price;
        this.imgLink = imgLink;
    }

    public Product(int id, Map<String, Object> data) {
        this.id = id;
        this.name = data.getOrDefault("name", "None").toString();
        this.description = data.getOrDefault("description", "None").toString();
        this.classify = data.getOrDefault("classify", "None").toString();
        this.price = (long) data.getOrDefault("price", "0");
        this.imgLink = data.getOrDefault("imgLink", "None").toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }
}
