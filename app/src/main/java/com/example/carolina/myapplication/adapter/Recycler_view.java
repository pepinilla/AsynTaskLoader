package com.example.carolina.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.carolina.myapplication.DataBase;
import com.example.carolina.myapplication.R;
import com.example.carolina.myapplication.entities.Locations;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 20/06/17.
 */

public class Recycler_view extends RecyclerView.Adapter<Recycler_view.ViewHolder> {

    private List<Locations> list;
    private OnItemClickListener clickListener;


    public Recycler_view() {
        this.list = new ArrayList<Locations>();
    }

    public void setClickListener(OnItemClickListener clickListener) {
        this.clickListener = clickListener;
    }


    @Override
    public Recycler_view.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    Locations locations = list.get(position);
        String place = locations.getLocations();
        holder.places.setText(place);

        if (this.clickListener != null){
            holder.setOnItemClickListener(locations, this.clickListener);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addToList(Locations locations){
        list.add(locations);
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        private View view;
        @Bind(R.id.places)
        TextView places;


        public ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }

        public void setOnItemClickListener (final Locations elements, final OnItemClickListener clickListener){
            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    clickListener.Onclick(elements);
                }
            });
        }


    }

}
