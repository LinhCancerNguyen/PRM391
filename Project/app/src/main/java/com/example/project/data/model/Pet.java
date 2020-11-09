package com.example.project.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

@Entity
public class Pet {
    @PrimaryKey
    @NonNull
    private String id = "0";
    @ColumnInfo
    private String name;

    public Pet() {
    }

    public Pet(String id, Map<String, Object> data) {
        this.id = id;
        this.name = data.getOrDefault("name", "None").toString();
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
}
