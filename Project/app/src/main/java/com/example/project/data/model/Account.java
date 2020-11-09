package com.example.project.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

@Entity
public class Account {
    @PrimaryKey
    @NonNull
    private String id = "0";
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String email;
    @ColumnInfo
    private String password;
    @ColumnInfo
    private String phone;

    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String id, Map<String, Object> data) {
        this.id = id;
        this.name = data.getOrDefault("name", "None").toString();
        this.email = data.getOrDefault("email", "None").toString();
        this.password = data.getOrDefault("password", "None").toString();
        this.phone = data.getOrDefault("phone", "None").toString();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
