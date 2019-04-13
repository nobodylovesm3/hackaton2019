package com.nmg.ecoraid.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nmg.ecoraid.R;
import com.nmg.ecoraid.adapters.AttendingCitiesAdapter;
import com.nmg.ecoraid.data.Raid;
import com.nmg.ecoraid.data.CityViewModel;
import com.nmg.ecoraid.models.Database;

import java.util.List;

public class AttendingRaidsFragment extends Fragment {
    static RecyclerView recyclerView;
    public static AttendingCitiesAdapter adapter;
    public static CityViewModel cityViewModel;
    public static Fragment fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.cities_layout, container, false);
        fragment = this;
        cityViewModel = ViewModelProviders.of(this).get(CityViewModel.class);
        recyclerView = itemView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AttendingCitiesAdapter();
        recyclerView.setAdapter(adapter);

        cityViewModel.getAllCities().observe(this, new Observer<List<Raid>>() {
            @Override
            public void onChanged(@Nullable List<Raid> cities) {
                adapter.setRaidList(cities);
                Database.setLikedCities(cities);
            }
        });
        return itemView;
    }

    public static void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }

}
