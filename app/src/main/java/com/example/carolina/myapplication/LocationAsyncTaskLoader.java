package com.example.carolina.myapplication;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v4.content.AsyncTaskLoader;

import com.example.carolina.myapplication.entities.Locations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 23/06/17.
 */

public class LocationAsyncTaskLoader extends AsyncTaskLoader<List<Locations>> {


    public LocationAsyncTaskLoader(Context context) {
        super(context);
    }

    @Override
    public List<Locations> loadInBackground() {
        return loadCities();
    }

    private List<Locations> loadCities(){

        return DataBase.getInstance().getList();

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

}
