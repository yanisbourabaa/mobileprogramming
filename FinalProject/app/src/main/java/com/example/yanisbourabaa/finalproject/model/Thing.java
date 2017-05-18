package com.example.yanisbourabaa.finalproject.model;

/**
 * Created by yanisbourabaa on 17/05/2017.
 */

public class Thing {
    private final int progress;
    private String thing;
    private boolean possible;

    public Thing(String thing, boolean possible, int progress) {
        this.thing = thing;
        this.possible = possible;
        this.progress = progress;
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public boolean isPossible() {
        return possible;
    }

    public void setPossible(boolean possible) {
        this.possible = possible;
    }

    public int getProgress() {
        return progress;
    }
}
