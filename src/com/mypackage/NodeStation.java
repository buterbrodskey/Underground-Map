package com.mypackage;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class NodeStation {
    Station station;
    private NodeStation prev = null;
    private NodeStation next = null;

    private ArrayList<NodeStation> transferStation = new ArrayList<>();

    boolean addTransferStation(NodeStation station) {
        return transferStation.add(station);
    }

    NodeStation(Station station) {
        this.station = station;
    }

    boolean hasNext() {
        return next!= null;
    }

    boolean hasPrev() {
        return !(prev == null);
    }

    public void setPrev(NodeStation prev) {
        this.prev = prev;
    }

    public void setNext(NodeStation next) {
        this.next = next;
    }

    public NodeStation getPrev() {
        return prev;
    }

    public NodeStation getNext() {
        return next;
    }

    @Override
    public String toString() {
        if (next == null) {
            return station.toString();
        }
        else {
            String result = new String();
            for (int i = 0; i < transferStation.size(); i++) {
                result += transferStation.get(i).station.getName()+ "(" +(MetroLine.getColorFromEcode(transferStation.get(i).station.getColor())) + ") ";
            }
            if (result.equals(""))
                return station.toString();
            else
            return
                    station +
                            " Переход(ы) на: " + result;
        }
    }
}
