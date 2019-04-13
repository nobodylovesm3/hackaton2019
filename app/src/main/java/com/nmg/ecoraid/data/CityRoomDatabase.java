package com.nmg.ecoraid.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Raid.class}, version = 1)
public abstract class CityRoomDatabase extends RoomDatabase {
    public abstract CityDAO cityDAO();

    private static CityRoomDatabase INSTANCE;


    static CityRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CityRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CityRoomDatabase.class, "word_database")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}
