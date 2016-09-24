package com.example.henrasetianugraha.basicdatabinding;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by Henra Setia Nugraha on 9/24/2016.
 */

public class MenuItem {
    public boolean iSpecial;
    public String flavor;
    public String price;
    public int index;
    public Map<String, String> map = new HashMap<>();

    public MenuItem(boolean iSpecial, String flavor, String price, int index) {
        this.iSpecial = iSpecial;
        this.flavor = flavor;
        this.price = price;
        this.index = index;
        map.put("flavor", flavor);
        map.put("price", price);
    }
}
