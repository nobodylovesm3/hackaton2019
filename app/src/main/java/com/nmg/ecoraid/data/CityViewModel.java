package com.nmg.ecoraid.data;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class CityViewModel extends AndroidViewModel {
    private CitiesRepository mRepository;

    private LiveData<List<Raid>> mAllWords;

    public CityViewModel(Application application) {
        super(application);
        mRepository = new CitiesRepository(application);
        mAllWords = mRepository.getmAllCities();
    }

    public LiveData<List<Raid>> getAllCities() { return mAllWords; }

    public void insert(Raid raid) { mRepository.insert(raid); }

    public void delete(Raid raid){mRepository.delete(raid);}
}
