package com.example.pablo.basededatosprojecto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Alumnos_table")

public class Alumnos {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "alumno")
    private String mAlumnos;

    Alumnos(@NonNull String alumnos) {
        this.mAlumnos = alumnos;
    }

    @NonNull
    public String getAlumnos() {
        return mAlumnos;
    }

    public void setAlumnos(@NonNull String mAlumnos) {
        this.mAlumnos = mAlumnos;
    }
}

