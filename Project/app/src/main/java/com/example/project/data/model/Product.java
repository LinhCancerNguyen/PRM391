package com.example.project.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Map;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String description;
    @ColumnInfo
    private int petID;
    @ColumnInfo
    private long price;
    @ColumnInfo
    private String imgLink;

    public Product() {
    }

    public Product(int id, String name, String description, int petID, long price, String imgLink) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.petID = petID;
        this.price = price;
        this.imgLink = imgLink;
    }

    public Product(String name, String description, int petID, long price, String imgLink) {
        this.name = name;
        this.description = description;
        this.petID = petID;
        this.price = price;
        this.imgLink = imgLink;
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

    public int getPetID() {
        return petID;
    }

    public void setPetID(int classify) {
        this.petID = petID;
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
