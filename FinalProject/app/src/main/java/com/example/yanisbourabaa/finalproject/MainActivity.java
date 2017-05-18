package com.example.yanisbourabaa.finalproject;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.yanisbourabaa.finalproject.datamanagers.DataManager;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;
import com.example.yanisbourabaa.finalproject.model.Day;
import com.example.yanisbourabaa.finalproject.model.Thing;
import com.example.yanisbourabaa.finalproject.ui.history.HistoryFragment;
import com.example.yanisbourabaa.finalproject.ui.home.HomeFragment;
import com.example.yanisbourabaa.finalproject.ui.stat.StatsFragment;

public class MainActivity extends AppCompatActivity {

    DataManager mDataManager = DataManagerImpl.getInstance();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("PerkUp");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, HomeFragment.newInstance()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_stats:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, StatsFragment.newInstance()).commit();
                                break;
                            case R.id.action_home:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, HomeFragment.newInstance()).commit();
                                break;
                            case R.id.action_history:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.main_container, HistoryFragment.newInstance()).commit();
                                break;
                        }
                        return true;
                    }
                });

        initData();
    }

    private void initData() {
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day(new Thing("Had good mark in mobile programmind", false), new Thing("had a hug from my crush", false), new Thing("cooked an amazing meal", false)));
        mDataManager.addDay(new Day());
    }
}
