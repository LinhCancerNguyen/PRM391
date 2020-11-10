package com.example.project.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project.data.model.Account;

import java.util.List;

@Dao
public interface AccountDAO {
    @Query("SELECT * FROM account")
    List<Account> all();
    @Query("SELECT * FROM account WHERE id = :id")
    Account get(int id);
    @Query("SELECT * FROM account WHERE email = :email AND password = :pass ")
    Account get(String email, String pass);
    @Insert
    void insert(Account... accounts);
    @Update
    void update(Account account);
    @Delete
    void delete(Account account);
}
