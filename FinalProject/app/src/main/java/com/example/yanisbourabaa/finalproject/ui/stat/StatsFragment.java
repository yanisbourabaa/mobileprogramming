package com.example.yanisbourabaa.finalproject.ui.stat;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yanisbourabaa.finalproject.R;


public class StatsFragment extends Fragment {



    public static Fragment newInstance() {
        return new StatsFragment();
    }

    public StatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stats, container, false);
    }

}
