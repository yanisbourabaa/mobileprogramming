package com.example.yanisbourabaa.finalproject.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanisbourabaa on 17/05/2017.
 */
public class Day {
    private List<Thing> things = new ArrayList<>();

    public Day() {
    }

    public Day(List<Thing> things) {
        this.things = things;
    }

    public Day(Thing thing1) {
        this.things.add(thing1);
    }

    public Day(Thing thing1, Thing thing2) {
        this.things.add(thing1);
        this.things.add(thing2);
    }

    public Day(Thing thing1, Thing thing2, Thing thing3) {
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
}
