package com.nmg.ecoraid.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "raid_table")
public class Raid {
    @NonNull
    @PrimaryKey
    private String cityName;
    @ColumnInfo(name = "raidInfo")
    private String cityInfo;
    @ColumnInfo(name = "imageUrl")
    private String imageUrl;
    @ColumnInfo(name = "isAttending")
    private boolean isAttended;

    @ColumnInfo(name = "recommendedPeople")
    private String recommendedPeople;

    @ColumnInfo(name = "currentPeople")
    private int currentPeople;


    public Raid(String cityName, String cityInfo, String imageUrl, String recommendedPeople) {
        this.cityName = cityName;
        this.cityInfo = cityInfo;
        this.imageUrl = imageUrl;
        this.recommendedPeople = recommendedPeople;
        isAttended = false;
        currentPeople = 0;
    }


    public int getCurrentPeople() {
        return currentPeople;
    }

    public void setCurrentPeople(int currentPeople) {
        this.currentPeople = currentPeople;
    }

    public String getRecommendedPeople() {
        return recommendedPeople;
    }

    public void setRecommendedPeople(String recommendedPeople) {
        this.recommendedPeople = recommendedPeople;
    }


    public boolean isAttended() {
        return isAttended;
    }

    public void setAttended(boolean attended) {
        isAttended = attended;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityInfo() {
        return cityInfo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
