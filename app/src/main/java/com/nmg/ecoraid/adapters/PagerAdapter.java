package com.nmg.ecoraid.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nmg.ecoraid.fragments.RaidsFragment;
import com.nmg.ecoraid.fragments.AttendingRaidsFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int itemCount;

    public PagerAdapter(FragmentManager fm, int itemCount) {
        super(fm);
        this.itemCount = itemCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new RaidsFragment();
            case 1:
                return new AttendingRaidsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return itemCount;
    }
}
