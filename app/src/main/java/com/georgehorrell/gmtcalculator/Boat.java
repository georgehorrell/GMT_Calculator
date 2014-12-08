package com.georgehorrell.gmtcalculator;

/**
 * Created by georgehorrell on 01/12/14.
 */
public class Boat {
    String name;
    int time;

    Boat(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String giveName() {
        return this.name;
    }

    public int giveTime() {
        return this.time;
    }

    public String toString() {
        return this.name;
    }

}

