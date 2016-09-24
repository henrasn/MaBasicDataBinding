package com.example.henrasetianugraha.basicdatabinding;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.henrasetianugraha.basicdatabinding.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBlankBinding dataBinding = FragmentBlankBinding.inflate(inflater,container,false);

        DataSource dataSource = DataSource.get("ieu fragment");

        dataBinding.setSource(dataSource);

        return dataBinding.getRoot();
    }

}
