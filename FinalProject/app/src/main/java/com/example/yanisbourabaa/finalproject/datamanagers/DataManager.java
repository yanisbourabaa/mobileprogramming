package com.example.yanisbourabaa.finalproject.datamanagers;

import com.example.yanisbourabaa.finalproject.model.Day;
import com.example.yanisbourabaa.finalproject.model.Thing;

import java.util.List;

/**
 * Created by yanisbourabaa on 17/05/2017.
 */
public interface DataManager {

    Day getCurrentDay();
    List<Day> getDays();
    void addDay(Day day);
    void addThing(Thing thing);
    void changeThing(int index, Thing thing);
    void addHappyThing(String happy);
    void addHappyThing(Thing happy);
    String getRandomHappy();
}
