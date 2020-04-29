package com.nmg.ecoraid.fragments;

import android.content.Intent;
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
import com.nmg.ecoraid.adapters.RaidsAdapter;
import com.nmg.ecoraid.data.Raid;
import com.nmg.ecoraid.models.Database;

import java.util.List;

public class RaidsFragment extends Fragment {
    private RecyclerView recyclerView;
    private static RaidsAdapter adapter;
    private List<Raid> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View itemView = inflater.inflate(R.layout.cities_layout, container, false);
        data = Database.getDatabase();
        recyclerView = itemView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RaidsAdapter(data);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return itemView;
    }

    public static void refreshAdapter() {
        adapter.notifyDataSetChanged();
    }
}
