package com.example.carolina.myapplication;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carolina.myapplication.entities.Locations;
import com.example.carolina.myapplication.fragment.Fragment_Listener;
import com.example.carolina.myapplication.fragment.Location_fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.editText)
    EditText location;
    Fragment_Listener fragment_listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Location_fragment fragment = (Location_fragment) getSupportFragmentManager().findFragmentById(R.id.fragment_list);
        fragment.setRetainInstance(true);
        fragment_listener = (Fragment_Listener) fragment;


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.more_info) {
//
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        hideKeyboard();
        String newplace = location.getText().toString().trim();
        if (!newplace.isEmpty()){
            Locations locations = new Locations();
            locations.setLocations(newplace);
            fragment_listener.addToList(locations);
            location.setText("");
            DataBase.getInstance().add(locations);
        }
    }

    public void hideKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void loadMoreInfo(MenuItem item) {
        Intent loadAboutMe = new Intent(getApplicationContext(),More_Info.class);
        startActivity(loadAboutMe);
    }
}
