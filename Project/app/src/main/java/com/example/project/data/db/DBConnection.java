package com.example.project.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project.data.model.Account;
import com.example.project.data.model.Orders;
import com.example.project.data.model.Pet;
import com.example.project.data.model.Product;

@Database(entities = {Account.class, Orders.class, Pet.class, Product.class}, version = 1)
public abstract class DBConnection extends RoomDatabase {
    public abstract AccountDAO getAccountDAO();
    public abstract OrderDAO getOrderDAO();
    public abstract PetDAO getPetDAO();
    public abstract ProductDAO getProductDAO();
}
