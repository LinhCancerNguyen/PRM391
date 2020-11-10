package com.example.project.data.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project.data.model.Pet;

import java.util.List;

@Dao
public interface PetDAO {
    @Query("SELECT * FROM pet")
    List<Pet> all();
    @Query("SELECT * FROM pet WHERE id = :id")
    Pet get(int id);
    @Insert
    void insert(Pet... pets);
    @Update
    void update(Pet pet);
    @Delete
    void delete(Pet pet);
}
