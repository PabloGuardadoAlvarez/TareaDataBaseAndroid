package com.example.pablo.basededatosprojecto.Clases;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface AlumnosDao {

    @Insert
    void insert(Alumnos alumno);

    @Query("DELETE FROM Alumnos_table")
    void deleteAll();

    @Query("SELECT * from Alumnos_table ORDER BY alumno ASC")
    LiveData<List<Alumnos>> getAllWords();
}
