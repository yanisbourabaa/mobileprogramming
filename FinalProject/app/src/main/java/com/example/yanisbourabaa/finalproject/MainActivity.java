package com.example.yanisbourabaa.finalproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yanisbourabaa.finalproject.datamanagers.DataManager;
import com.example.yanisbourabaa.finalproject.datamanagers.DataManagerImpl;
import com.example.yanisbourabaa.finalproject.model.Day;
import com.example.yanisbourabaa.finalproject.model.Thing;
import com.example.yanisbourabaa.finalproject.ui.HappyActivity;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_happy:
                startActivity(new Intent(this, HappyActivity.class));
                break;
        }
        return true;
    }

    private void initData() {
        mDataManager.addDay(new Day("May 11", new Thing("Had good mark in mobile programming", false, 75), new Thing("had a hug from my crush", false, 12), new Thing("cooked an amazing meal", false, 22)));
        mDataManager.addDay(new Day("May 10", new Thing("have a talk with little bro", false, 12), new Thing("have a beer", false, 50), new Thing("cooked an amazing meal", false, 50)));
        mDataManager.addDay(new Day("May 9", new Thing("play soccer", false, 42), new Thing("had a hug from my crush", false, 50), new Thing("cooked an amazing meal", false, 75)));
        mDataManager.addDay(new Day("May 8", new Thing("go to cinema", false, 50), new Thing("had a hug from my crush", false, 14), new Thing("cooked an amazing meal", false, 22)));
        mDataManager.addDay(new Day("May 7", new Thing("Had good mark in mobile programming", false, 42), new Thing("had a hug from my crush", false, 75), new Thing("cooked an amazing meal", false, 12)));
        mDataManager.addDay(new Day("May 6", new Thing("Had good mark in mobile programming", false, 22), new Thing("had a hug from my crush", false, 12), new Thing("cooked an amazing meal", false, 14)));
        mDataManager.addDay(new Day("May 5", new Thing("Had good mark in mobile programming", false, 22), new Thing("had a hug from my crush", false, 50), new Thing("cooked an amazing meal", false, 75)));
        mDataManager.addDay(new Day("May 4", new Thing("Had good mark in mobile programming", false, 14), new Thing("had a hug from my crush", false, 75), new Thing("cooked an amazing meal", false, 50)));
        mDataManager.addDay(new Day("May 3", new Thing("Had good mark in mobile programming", false, 75), new Thing("had a hug from my crush", false, 75), new Thing("cooked an amazing meal", false, 12)));
        mDataManager.addDay(new Day("May 2", new Thing("Had good mark in mobile programming", false, 75), new Thing("had a hug from my crush", false, 22), new Thing("cooked an amazing meal", false, 75)));
        mDataManager.addDay(new Day("May 1", new Thing("Had good mark in mobile programming", false, 50), new Thing("had a hug from my crush", false, 12), new Thing("cooked an amazing meal", false, 50)));
       mDataManager.addDay(new Day("May 12"));

        mDataManager.addHappyThing("eat mcdonald's");
        mDataManager.addHappyThing("go to cinema");
        mDataManager.addHappyThing("play soccer");
        mDataManager.addHappyThing("have a beer");
        mDataManager.addHappyThing("have a talk with little bro");
        mDataManager.addHappyThing("take a nap");
    }
}
