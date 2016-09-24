package com.example.henrasetianugraha.basicdatabinding;

/**
 * Created by Henra Setia Nugraha on 9/21/2016.
 */

public class DataSource {
    private String name;

    public DataSource(String name) {
        this.name=name;
    }

    public static DataSource get(String name){
        return new DataSource(name);
    }

    public String getMessage(){
        return String.format("Hello, %s!",name);
    }

    public void watch(){

    }
}
