package com.nmg.ecoraid.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nmg.ecoraid.R;
import com.nmg.ecoraid.data.Raid;
import com.nmg.ecoraid.fragments.RaidsFragment;
import com.nmg.ecoraid.fragments.AttendingRaidsFragment;
import com.nmg.ecoraid.models.LoadImageTask;

import java.util.List;

import static com.nmg.ecoraid.models.Database.removeLikedCity;

public class AttendingCitiesAdapter extends RecyclerView.Adapter<AttendingCitiesAdapter.MyCitiesViewHolder> {
    private List<Raid> raidList;


    @NonNull
    @Override
    public MyCitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_layout, parent, false);
        return new MyCitiesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyCitiesViewHolder viewHolder, int position) {
        final Raid raid = raidList.get(position);
        viewHolder.txtCityName.setText(raid.getCityName());
        viewHolder.txtCityInfo.setText(raid.getCityInfo());
        LoadImageTask loadImageTask = new LoadImageTask(viewHolder.imgCity);
        loadImageTask.execute(raid.getImageUrl());
        viewHolder.btnLikeUnlike.setText("Unattend");
        viewHolder.txtCurrentPeople.setText("1");
        viewHolder.txtRecommendedPeople.setText(raid.getRecommendedPeople());

        viewHolder.btnLikeUnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                raid.setAttended(false);
                removeLikedCity(raid);
                viewHolder.txtCurrentPeople.setText("0");
                notifyDataSetChanged();
                AttendingRaidsFragment.cityViewModel.delete(raid);
                RaidsFragment.refreshAdapter();

            }
        });
    }

    @Override
    public int getItemCount() {
        if (raidList != null) {
            return raidList.size();
        } else {
            return 0;
        }
    }

    public void setRaidList(List<Raid> raidList) {
        this.raidList = raidList;
        notifyDataSetChanged();
    }

    public List<Raid> getRaidList() {
        return this.raidList;
    }


    public static class MyCitiesViewHolder extends RecyclerView.ViewHolder {
        private TextView txtCityName;
        private TextView txtCityInfo;
        private ImageView imgCity;
        private Button btnLikeUnlike;
        private TextView txtCurrentPeople;
        private TextView txtRecommendedPeople;

        public MyCitiesViewHolder(View itemView) {
            super(itemView);
            txtCityName = itemView.findViewById(R.id.txt_city_name);
            txtCityInfo = itemView.findViewById(R.id.txt_city_info);
            imgCity = itemView.findViewById(R.id.img_city);
            btnLikeUnlike = itemView.findViewById(R.id.btn_like_unlike);
            txtCurrentPeople = itemView.findViewById(R.id.txt_curr_people);
            txtRecommendedPeople = itemView.findViewById(R.id.txt_rcmd_people);

        }
    }
}

