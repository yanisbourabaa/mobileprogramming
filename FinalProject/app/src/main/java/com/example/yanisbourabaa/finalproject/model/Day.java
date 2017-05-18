package com.example.yanisbourabaa.finalproject.model;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanisbourabaa on 17/05/2017.
 */
public class Day {
    private List<Thing> things = new ArrayList<>();
    private String date;

    public Day(String date) {
        this.date = date;
    }

    public Day(String date, List<Thing> things) {
        this.things = things;
        this.date = date;
    }

    public Day(String date, Thing thing1) {
        this.things.add(thing1);
        this.date = date;
    }

    public Day(String date, Thing thing1, Thing thing2) {
        this.date = date;
        this.things.add(thing1);
        this.things.add(thing2);
    }

    public Day(String date, Thing thing1, Thing thing2, Thing thing3) {
        this.date = date;
        this.things.add(thing1);
        this.things.add(thing2);
        this.things.add(thing3);
    }

    public void addThing(Thing thing) {
        if (things.size() < 3) {
            things.add(thing);
        }
    }

    public void changeThing(int index, Thing thing) {
        if (index < things.size()) {
            things.set(index, thing);
        }
    }

    public void removeThing(int index) {
        things.remove(index);
    }

    public List<Thing> getThings() {
        return things;
    }

    public String getDate() {
        return date;
    }
}
