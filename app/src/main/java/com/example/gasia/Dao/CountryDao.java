package com.example.gasia.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gasia.models.Country;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CountryDao {
    @Insert(onConflict =REPLACE)
    void insert(List<Country> posts);

    @Query("SELECT * FROM country")
    LiveData<List<Country>> getAllCountry();

    @Query("DELETE FROM country")
    void deleteAll();
}
