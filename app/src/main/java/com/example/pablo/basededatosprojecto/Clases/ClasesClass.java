package com.example.pablo.basededatosprojecto.Clases;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Clases_table")

public class ClasesClass {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ID")
    private int mclaseid;

    @ColumnInfo(name = "Nombre")
    private String mclaseNombre;

    @ColumnInfo(name = "Profesor")
    private String mclaseProfe;

    @ColumnInfo(name = "Numero_Alumnos")
    private int mClaseAlumnos;

    @ColumnInfo(name = "Numeros_horas")
    private int mClaseHoras;


    public ClasesClass(@NonNull int claseId, String claseNombre, String clasesProfe, int claseAlumnos, int claseHoras) {
        this.mclaseid = claseId;
        this.mclaseNombre = claseNombre;
        this.mclaseProfe = clasesProfe;
        this.mClaseAlumnos = claseAlumnos;
        this.mClaseHoras = claseHoras;
    }

    public int getMclaseid() {
        return mclaseid;
    }

    public void setMclaseid(int mclaseid) {
        this.mclaseid = mclaseid;
    }

    public String getMclaseNombre() {
        return mclaseNombre;
    }

    public void setMclaseNombre(String mclaseNombre) {
        this.mclaseNombre = mclaseNombre;
    }

    public String getMclaseProfe() {
        return mclaseProfe;
    }

    public void setMclaseProfe(String mclaseProfe) {
        this.mclaseProfe = mclaseProfe;
    }

    public int getMClaseAlumnos() {
        return mClaseAlumnos;
    }

    public void setMClaseAlumnos(int mClaseAlumnos) {
        this.mClaseAlumnos = mClaseAlumnos;
    }

    public int getMClaseHoras() {
        return mClaseHoras;
    }

    public void setMClaseHoras(int mClaseHoras) {
        this.mClaseHoras = mClaseHoras;
    }
}
