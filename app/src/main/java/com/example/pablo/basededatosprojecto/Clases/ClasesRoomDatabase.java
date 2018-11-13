package com.example.pablo.basededatosprojecto.Clases;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import com.example.pablo.basededatosprojecto.BuildConfig;

@Database(entities = {ClasesClass.class}, version = 1)
public abstract class ClasesRoomDatabase extends RoomDatabase {

    public abstract ClaseDao claseDao();

    private static ClasesRoomDatabase INSTANCE;

    static ClasesRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClasesRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ClasesRoomDatabase.class, BuildConfig.DATABASE_NAME)
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final ClaseDao mDao;
    int[] IDClases = {1,2,3};
    String[] nombresClases = {"clase 1", "clase 2", "clase  3"};
    int[] alumnosClases = {20,20,18};
    String[] profesorClases = {"david", "carlos", "pedro"};
    int[] HorasClases = {4,6,2};

    PopulateDbAsync(ClasesRoomDatabase db) {
        mDao = db.claseDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        // Start the app with a clean database every time.
        // Not needed if you only populate the database
        // when it is first created
        mDao.deleteAll();

        for (int i = 0; i <= IDClases.length - 1; i++) {
            ClasesClass clase = new ClasesClass(IDClases[0],nombresClases[i] ,profesorClases[i],alumnosClases[i] ,HorasClases[i]);
            mDao.insert(clase);
        }
        return null;
    }
}
