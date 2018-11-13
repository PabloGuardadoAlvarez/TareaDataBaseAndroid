package com.example.pablo.basededatosprojecto;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class AlumnosRepository {

    private AlumnosDao mAlumnosDao;
    private LiveData<List<Alumnos>> mAllAlumnos;

    AlumnosRepository(Application application) {
        AlumnosRoomDatabese db = AlumnosRoomDatabese.getDatabase(application);
        mAlumnosDao = db.alumnosDao();
        mAllAlumnos = mAlumnosDao.getAllWords();
    }

    LiveData<List<Alumnos>> getmAllAlumnos() {
        return mAllAlumnos;
    }

    public void insert(Alumnos alumnos) {
        new insertAsyncTask(mAlumnosDao).execute(alumnos);
    }
}

class insertAsyncTask extends AsyncTask<Alumnos, Void, Void> {

    private AlumnosDao mAsyncTaskDao;

    insertAsyncTask(AlumnosDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Alumnos... params) {
        mAsyncTaskDao.insert(params[0]);
        return null;
    }
}


