package com.example.pablo.basededatosprojecto.Clases;

import android.annotation.SuppressLint;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.example.pablo.basededatosprojecto.BuildConfig;

@Database(entities = {Alumnos.class}, version = 1)

abstract class AlumnosRoomDatabase extends RoomDatabase {

    public abstract AlumnosDao alumnosDao();

    private static AlumnosRoomDatabase INSTANCE;

    public static AlumnosRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AlumnosRoomDatabase.class) {
                if (INSTANCE == null) {

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AlumnosRoomDatabase.class, BuildConfig.DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @SuppressLint("NewApi")
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}

class PopulateDbAsync1 extends AsyncTask<Void, Void, Void> {

    private final AlumnosDao mDao;
    String[] alumnos = {"dolphin", "crocodile", "cobra"};

    PopulateDbAsync1(AlumnosRoomDatabase db) {
        mDao = db.alumnosDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        // Start the app with a clean database every time.
        // Not needed if you only populate the database
        // when it is first created
        mDao.deleteAll();

        for (int i = 0; i <= alumnos.length - 1; i++) {
            Alumnos word = new Alumnos(alumnos[i]);
            mDao.insert(word);
        }
        return null;
    }
}
