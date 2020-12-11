package com.mypackage;

import java.util.ArrayList;

public class NodeStation {
    Station station;
    Station prev = null;
    Station next = null;
    NodeStation(String name, COLOR color) {
        station = new Station(name,color);
    }
}
