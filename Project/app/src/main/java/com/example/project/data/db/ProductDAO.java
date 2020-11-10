package com.example.project.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project.data.model.Product;

import java.util.List;

@Dao
public interface ProductDAO {
    @Query("SELECT * FROM product")
    List<Product> all();
    @Query("SELECT * FROM product WHERE id = :id")
    Product get(int id);
    @Insert
    void insert(Product... products);
    @Update
    void update(Product product);
    @Delete
    void delete(Product product);
}
