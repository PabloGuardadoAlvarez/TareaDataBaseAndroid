package com.example.pablo.basededatosprojecto;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClaseDao {

    @Insert
    void insert(ClasesClass clasesClass);

    @Query("DELETE FROM clases_table")
    void deleteAll();

    @Query("SELECT * from clases_table ORDER BY nombre ASC")
    LiveData<List<ClasesClass>> getAllClases();
}
