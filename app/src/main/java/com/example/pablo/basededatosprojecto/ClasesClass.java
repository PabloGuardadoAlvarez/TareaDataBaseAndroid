package com.example.pablo.basededatosprojecto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Clases_table")

public class ClasesClass {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int Claseid;

    @ColumnInfo(name = "Nombre")
    private String ClaseNombre;

    @ColumnInfo(name = "Profesor")
    private String ClaseProfe;

    @ColumnInfo(name = "Numero_Alumnos")
    private int ClaseAlumnos;

    @ColumnInfo(name = "Numeros_horas")
    private int ClaseHoras;


    public ClasesClass(@NonNull int claseId, String claseNombre, String clasesProfe, int claseAlumnos, int claseHoras) {
        this.Claseid = claseId;
        this.ClaseNombre = claseNombre;
        this.ClaseProfe = clasesProfe;
        this.ClaseAlumnos = claseAlumnos;
        this.ClaseHoras = claseHoras;
    }

    public int getClaseid() {
        return Claseid;
    }

    public void setClaseid(int claseid) {
        Claseid = claseid;
    }

    public String getClaseNombre() {
        return ClaseNombre;
    }

    public void setClaseNombre(String claseNombre) {
        ClaseNombre = claseNombre;
    }

    public String getClaseProfe() {
        return ClaseProfe;
    }

    public void setClaseProfe(String claseProfe) {
        ClaseProfe = claseProfe;
    }

    public int getClaseAlumnos() {
        return ClaseAlumnos;
    }

    public void setClaseAlumnos(int claseAlumnos) {
        ClaseAlumnos = claseAlumnos;
    }

    public int getClaseHoras() {
        return ClaseHoras;
    }

    public void setClaseHoras(int claseHoras) {
        ClaseHoras = claseHoras;
    }
}
