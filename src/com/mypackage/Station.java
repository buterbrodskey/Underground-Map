package com.mypackage;

import java.util.ArrayList;

public class Station {
    private final String name;
    private final COLOR color;
    public Station(String name, COLOR color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public COLOR getColor() {
        return color;
    }


    @Override
    public String toString() {
        //return "Название: " + getName() + " Цвет ветки: " + getColor() + " Переход(ы) на: " + transientStation.toString();
        return "" + getName();
    }
}
//    String listTransStationGenerate() {
//        String result = new String();
//        for (String o : transientStation) {
//            result.concat(o);
//        }
//        return result;
//    }
