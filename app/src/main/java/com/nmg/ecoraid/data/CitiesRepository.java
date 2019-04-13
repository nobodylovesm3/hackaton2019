package com.nmg.ecoraid.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CitiesRepository {
    private CityDAO mCityDao;
    private LiveData<List<Raid>> mAllCities;

    CitiesRepository(Application application) {
        CityRoomDatabase db = CityRoomDatabase.getDatabase(application);
        mCityDao = db.cityDAO();
        mAllCities = mCityDao.getAllCities();
    }

    LiveData<List<Raid>> getmAllCities() {
        return mAllCities;
    }

    public void insert(Raid raid) {
        new insertAsyncTask(mCityDao).execute(raid);
    }

    public void delete(Raid raid) {
        new deleteAsyncTask(mCityDao).execute(raid);
    }

    private static class insertAsyncTask extends AsyncTask<Raid, Void, Void> {

        private CityDAO mAsyncTaskDao;

        insertAsyncTask(CityDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Raid... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Raid, Void, Void> {

        private CityDAO mAsyncTaskDao;

        deleteAsyncTask(CityDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Raid... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}
