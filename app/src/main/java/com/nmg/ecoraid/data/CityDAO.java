package com.nmg.ecoraid.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface CityDAO {
    @Insert
    void insert(Raid raid);
    @Query("DELETE FROM raid_table")
    void deleteAll();
    @Delete
    void delete(Raid raid);
    @Query("SELECT * from raid_table ORDER BY cityName ASC")
    LiveData<List<Raid>> getAllCities();
}
