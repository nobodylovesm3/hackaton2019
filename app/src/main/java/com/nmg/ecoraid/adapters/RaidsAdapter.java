package com.nmg.ecoraid.adapters;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nmg.ecoraid.R;
import com.nmg.ecoraid.data.Raid;
import com.nmg.ecoraid.data.CityViewModel;
import com.nmg.ecoraid.fragments.AttendingRaidsFragment;
import com.nmg.ecoraid.models.Database;
import com.nmg.ecoraid.models.LoadImageTask;

import java.util.List;


public class RaidsAdapter extends RecyclerView.Adapter<RaidsAdapter.CitiesViewHolder> {

    private List<Raid> raidList;
    public static CityViewModel cityViewModel;

    public RaidsAdapter(List<Raid> raidList) {
        this.raidList = raidList;
    }

    @NonNull
    @Override
    public CitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_layout, parent, false);
        cityViewModel = ViewModelProviders.of(AttendingRaidsFragment.fragment).get(CityViewModel.class);
        return new CitiesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final CitiesViewHolder viewHolder, int position) {
        final Raid raid = raidList.get(position);
        viewHolder.txtCityName.setText(raid.getCityName());
        viewHolder.txtCityInfo.setText(raid.getCityInfo());
        LoadImageTask loadImageTask = new LoadImageTask(viewHolder.imgCity);
        loadImageTask.execute(raid.getImageUrl());
        viewHolder.txtRecommendedPeople.setText(raid.getRecommendedPeople());
        viewHolder.txtCurrentPeople.setText("0");

        cityViewModel.getAllCities().observe(AttendingRaidsFragment.fragment, new Observer<List<Raid>>() {
            @Override
            public void onChanged(@Nullable List<Raid> cities) {
                Database.setLikedCities(cities);

            }
        });

        if (Database.isLikedCity(raid.getCityName())) {
            viewHolder.btnLikeUnlike.setText("Unattend");
        } else {
            viewHolder.btnLikeUnlike.setText("Attend");
        }

        viewHolder.imgCity.setOnClickListener(v ->{

        } );
        viewHolder.btnLikeUnlike.setOnClickListener(view -> {

            if (viewHolder.btnLikeUnlike.getText().equals("Unattend")) {
                viewHolder.btnLikeUnlike.setText("Attend");
                viewHolder.txtCurrentPeople.setText("0");
                raid.setAttended(false);
                Database.removeLikedCity(raid);
                AttendingRaidsFragment.refreshAdapter();
                AttendingRaidsFragment.cityViewModel.delete(raid);
            } else {
                viewHolder.btnLikeUnlike.setText("Unattend");
                viewHolder.txtCurrentPeople.setText("1");
                raid.setAttended(true);
                Database.addLikedCity(raid);

                AttendingRaidsFragment.refreshAdapter();
                AttendingRaidsFragment.cityViewModel.insert(raid);
            }
        });
    }



    @Override
    public int getItemCount() {
        return raidList.size();
    }

    public static class CitiesViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCityName;
        private TextView txtCityInfo;
        private ImageView imgCity;
        private Button btnLikeUnlike;
        private TextView txtRecommendedPeople;
        private TextView txtCurrentPeople;

        public CitiesViewHolder(View itemView) {
            super(itemView);
            txtCityName = itemView.findViewById(R.id.txt_city_name);
            txtCityInfo = itemView.findViewById(R.id.txt_city_info);
            imgCity = itemView.findViewById(R.id.img_city);
            btnLikeUnlike = itemView.findViewById(R.id.btn_like_unlike);
            txtRecommendedPeople = itemView.findViewById(R.id.txt_rcmd_people);
            txtCurrentPeople = itemView.findViewById(R.id.txt_curr_people);
        }
    }
}

