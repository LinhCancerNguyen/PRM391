package com.example.project.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

@Entity
public class Pet {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String name;

    public Pet() {
    }

    public Pet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet(int id, Map<String, Object> data) {
        this.id = id;
        this.name = data.getOrDefault("name", "None").toString();
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
}
