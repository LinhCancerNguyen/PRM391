package com.example.project.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project.data.model.Orders;

import java.util.List;

@Dao
public interface OrderDAO {
    @Query("SELECT * FROM orders")
    List<Orders> all();
    @Query("SELECT * FROM orders WHERE id = :id")
    Orders get(String id);
    @Insert
    void insert(Orders... orders);
    @Update
    void update(Orders order);
    @Delete
    void delete(Orders order);
}
