package com.example.carolina.myapplication;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.carolina.myapplication.entities.Locations;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by carolina on 23/06/17.
 */

public class LoaderList extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List> {


    @Bind(R.id.loaderList)
    ListView loaderList;
    List<Locations> listofplaces = new ArrayList<Locations>();//DataBase.getInstance().getList();
    ArrayAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loaderlist);
        ButterKnife.bind(this);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listofplaces);
        loaderList.setAdapter(adapter);
        getSupportLoaderManager().initLoader(0, null, this);

    }

    @Override
    public Loader<List> onCreateLoader(int id, Bundle args) {
        Loader loader = new LocationAsyncTaskLoader(getApplicationContext());
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<List> loader, List data) {
        listofplaces.clear();
        listofplaces.addAll(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<List> loader) {
        listofplaces.clear();

    }
}
