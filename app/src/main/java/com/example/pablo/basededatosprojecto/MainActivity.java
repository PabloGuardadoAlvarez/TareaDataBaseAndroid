package com.example.pablo.basededatosprojecto;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClasesRoomDatabase.getDatabase(this).claseDao().getAllClases().observe(this, new Observer<List<ClasesClass>>() {

            @Override
            public void onChanged(@Nullable List<Alumnos> clases) {

                if (clases != null) {

                    Log.d("Database", clases.toString());

                }

            }

        });
    }
}
