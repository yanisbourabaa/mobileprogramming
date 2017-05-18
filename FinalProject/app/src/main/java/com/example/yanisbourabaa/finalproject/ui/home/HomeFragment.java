package com.example.yanisbourabaa.finalproject.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yanisbourabaa.finalproject.R;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManager;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;
import com.example.yanisbourabaa.finalproject.model.Day;
import com.example.yanisbourabaa.finalproject.model.Thing;
import com.example.yanisbourabaa.finalproject.ui.goodthings.AddGoodThingActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {

    public static final String INDEX_OF_GOODTHING = "INDEX_OF_GOODTHING";
    public static final String GOODTHING_IS_EMPTY = "GOODTHING_IS_EMPTY";
    RelativeLayout goodThing1;
    RelativeLayout goodThing2;
    RelativeLayout goodThing3;
    TextView tvGoodThing1;
    TextView tvGoodThing2;
    TextView tvGoodThing3;

    DataManager mDataManager = DataManagerImpl.getInstance();
    List<Thing> thingList = new ArrayList<>();


    public static Fragment newInstance() {
        return new HomeFragment();
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        goodThing1 = (RelativeLayout) v.findViewById(R.id.frag_home_rl_goodthing1);
        goodThing2 = (RelativeLayout) v.findViewById(R.id.frag_home_rl_goodthing2);
        goodThing3 = (RelativeLayout) v.findViewById(R.id.frag_home_rl_goodthing3);
        tvGoodThing1 = (TextView) v.findViewById(R.id.frag_home_tv_goodthing1);
        tvGoodThing2 = (TextView) v.findViewById(R.id.frag_home_tv_goodthing2);
        tvGoodThing3 = (TextView) v.findViewById(R.id.frag_home_tv_goodthing3);

        goodThing1.setOnClickListener(this);
        goodThing2.setOnClickListener(this);
        goodThing3.setOnClickListener(this);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        Day current_day = mDataManager.getCurrentDay();
        if (current_day != null) {
           thingList = current_day.getThings();
        } else {
            return;
        }
        if (thingList.size() > 0)
            tvGoodThing1.setText(thingList.get(0).getThing());
        if (thingList.size() > 1)
            tvGoodThing2.setText(thingList.get(1).getThing());
        if (thingList.size() > 2)
            tvGoodThing3.setText(thingList.get(2).getThing());
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(getContext(), AddGoodThingActivity.class);
        switch (v.getId()) {
            case R.id.frag_home_rl_goodthing1:
                i.putExtra(INDEX_OF_GOODTHING, 0);
                i.putExtra(GOODTHING_IS_EMPTY, !(thingList.size() > 0));
                break;
            case R.id.frag_home_rl_goodthing2:
                i.putExtra(INDEX_OF_GOODTHING, 1);
                i.putExtra(GOODTHING_IS_EMPTY, !(thingList.size() > 1));
                break;
            case R.id.frag_home_rl_goodthing3:
                i.putExtra(INDEX_OF_GOODTHING, 2);
                i.putExtra(GOODTHING_IS_EMPTY, !(thingList.size() > 2));
                break;
        }
        startActivity(i);
    }
}
