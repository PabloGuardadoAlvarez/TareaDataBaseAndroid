package com.example.pablo.basededatosprojecto.Clases;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class ClasesRepository {

    private ClaseDao mClaseDao;
    private LiveData<List<ClasesClass>> mAllClases;

    ClasesRepository(Application application) {
        ClasesRoomDatabase db = ClasesRoomDatabase.getDatabase(application);
        mClaseDao = db.claseDao();
        mAllClases = mClaseDao.getAllClases();
    }

    LiveData<List<ClasesClass>> getmAllClases() {
        return mAllClases;
    }

    public void insert (ClasesClass clasesClass) {
        new insertAsyncTask(mClaseDao).execute(clasesClass);
    }

    private static class insertAsyncTask extends AsyncTask<ClasesClass, Void, Void> {

        private ClaseDao mAsyncTaskDao;

        insertAsyncTask(ClaseDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ClasesClass... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
