package com.example.carolina.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.carolina.myapplication.LoaderList;
import com.example.carolina.myapplication.R;
import com.example.carolina.myapplication.adapter.OnItemClickListener;
import com.example.carolina.myapplication.adapter.Recycler_view;
import com.example.carolina.myapplication.entities.Locations;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 22/06/17.
 */

public class Location_fragment extends Fragment implements Fragment_Listener, OnItemClickListener {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;
    Recycler_view adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        ButterKnife.bind(this, view);
        setAdapter();
        setRecyclerView();
        return view;
    }

    private void setAdapter(){
        if (adapter ==null){
            adapter = new Recycler_view();
            adapter.setClickListener(this);
        }
    }

    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void addToList(Locations locations) {
        adapter.addToList(locations);
    }

    @Override
    public void Onclick(Locations locations) {
        Intent i = new Intent(getActivity(), LoaderList.class);
        startActivity(i);
    }
}
