package com.example.pablo.basededatosprojecto.Clases;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class AlumnosViewModel extends AndroidViewModel {

    private AlumnosRepository mRepository;

    private LiveData<List<Alumnos>> mAllAlumnos;


    public AlumnosViewModel(Application application) {
        super(application);
        mRepository = new AlumnosRepository(application);
        mAllAlumnos = mRepository.getmAllAlumnos();
    }

    LiveData<List<Alumnos>> getmAllAlumnos() {
        return mAllAlumnos;
    }

    public void insert(Alumnos word) {
        mRepository.insert(word);
    }
}

