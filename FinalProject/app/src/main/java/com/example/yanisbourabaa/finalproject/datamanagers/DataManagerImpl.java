package com.example.yanisbourabaa.finalproject.datamanagers;

import com.example.yanisbourabaa.finalproject.model.Day;
import com.example.yanisbourabaa.finalproject.model.Thing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanisbourabaa on 17/05/2017.
 */

public class DataManagerImpl implements  DataManager  {

    private static DataManager INSTANCE = new DataManagerImpl();

    List<Day> days = new ArrayList<>();

    public static DataManager getInstance() {
        return INSTANCE;
    }

    @Override
    public Day getCurrentDay() {
        if (days.size() > 0)
            return days.get(days.size() - 1);
        return null;
    }

    @Override
    public List<Day> getDays() {
        return days;
    }

    @Override
    public void addDay(Day day) {
        days.add(day);
    }

    @Override
    public void addThing(Thing thing) {
        getCurrentDay().addThing(thing);
    }

    @Override
    public void changeThing(int index, Thing thing) {
        getCurrentDay().changeThing(index, thing);
    }
}
