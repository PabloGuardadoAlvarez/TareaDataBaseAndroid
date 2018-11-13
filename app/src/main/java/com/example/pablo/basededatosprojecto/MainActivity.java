package com.example.pablo.basededatosprojecto;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.pablo.basededatosprojecto.Clases.Alumnos;
import com.example.pablo.basededatosprojecto.Clases.AlumnosRoomDatabese;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlumnosRoomDatabese.getDatabase(this).alumnosDao().getAllWords().observe(this, new Observer<List<Alumnos>>() {
            @Override
            public void onChanged(@Nullable List<Alumnos> alumnos) {

                if (alumnos != null) {

                    Log.d("Database", alumnos.toString());

                }

            }

        });
    }
}
