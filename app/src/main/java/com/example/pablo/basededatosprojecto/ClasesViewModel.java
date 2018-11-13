package com.example.pablo.basededatosprojecto;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class ClasesViewModel extends AndroidViewModel {

    private ClasesRepository mRepository;

    private LiveData<List<ClasesClass>> mAllWords;

    public ClasesViewModel(Application application) {
        super(application);
        mRepository = new ClasesRepository(application);
        mAllWords = mRepository.getmAllClases();
    }

    LiveData<List<ClasesClass>> getAllWords() {
        return mAllWords;
    }

    public void insert(ClasesClass clases) {
        mRepository.insert(clases);
    }
}
