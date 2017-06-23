package com.example.carolina.myapplication;

import com.example.carolina.myapplication.entities.Locations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by carolina on 23/06/17.
 */

public class DataBase {


    List<Locations> list = new ArrayList<Locations>();

    private static volatile DataBase INSTANCE;

    public static DataBase getInstance(){
        DataBase localInstance = INSTANCE;
        if (localInstance == null) {
            synchronized (DataBase.class){
                localInstance = INSTANCE;
                if (localInstance == null){
                    localInstance = INSTANCE = new DataBase();
                }
            }

        }
        return localInstance;
    }

    public List<Locations> getList() {
        return list;
    }

    public void add(Locations locations){
        list.add(locations);
    }

}
