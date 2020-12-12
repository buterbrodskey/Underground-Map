package com.mypackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StationContainerInit {
    ArrayList<MetroLine> initUnderground() {
        ArrayList<NodeStation> stations = new ArrayList<>();
        ArrayList<MetroLine> Underground = new ArrayList<>();

        try {
            addAllStation(stations);
            addAllTransfer(stations);
            addAllMetroLine(Underground, stations);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        MetroLine RedLine = Underground.get(0);
        MetroLine GreenLine = Underground.get(1);
        MetroLine BlueLine = Underground.get(2);
        MetroLine SkyLine = Underground.get(3);
        MetroLine BrownLine = Underground.get(4);
        MetroLine OrangeLine = Underground.get(5);
        MetroLine Violetline = Underground.get(6);
        MetroLine YellowSunLine = Underground.get(7);
        MetroLine YellowKalinynLine = Underground.get(8);
        MetroLine GrayLine = Underground.get(9);
        MetroLine LightGreenLine = Underground.get(10);
        MetroLine AzureLine = Underground.get(11);
        MetroLine LightBlueLine = Underground.get(12);
//
//        addTrans(RedLine,"Парк Культуры",BrownLine, "Парк Культуры");
//
//        addTrans(RedLine,"Библиотека имени Ленина",BlueLine, "Арбатская");
//        addTrans(RedLine,"Библиотека имени Ленина",GrayLine, "Боровицкая");
//        addTrans(RedLine,"Библиотека имени Ленина",SkyLine, "Александровский сад");
//
//        addTrans(RedLine,"Охотный ряд",GreenLine, "Театральная");
//        addTrans(RedLine,"Охотный ряд",BlueLine, "Площадь Революции");
//
//        addTrans(RedLine,"Лубянка",Violetline, "Кузнецкий мост");
//
//        addTrans(RedLine,"Чистые пруды",LightGreenLine, "Сретенский бульвар");
//        addTrans(RedLine,"Чистые пруды",OrangeLine, "Тургеневская");
//
//        addTrans(RedLine,"Комсомольская",BrownLine, "Комсомольская");
//
//        RedLine.info();
        return Underground;
    }

    private void addAllTransfer(ArrayList<NodeStation> stations) throws FileNotFoundException {
        File file = new File("src/Resources/TransferStationListLite");
        Scanner scanner = new Scanner(file);
        String rootLine;
        String rootStation;
        String transferLine;
        String transferStation;


        while (scanner.hasNextLine()) {

            rootLine = scanner.nextLine();
            rootStation = scanner.nextLine();

            while (scanner.hasNextLine()) {

                transferLine = scanner.nextLine();
                if (transferLine.equals("")) break;
                transferStation = scanner.nextLine();

                getStation(stations, rootStation, MetroLine.getECodeFromColor(rootLine))
                        .addTransferStation(getStation(stations, transferStation, MetroLine.getECodeFromColor(transferLine)));
            }
        }
    }

    private NodeStation getStation(ArrayList<NodeStation> stations, String name, COLOR color) {
        for (NodeStation station : stations) {
            if (station.station.getName().equals(name) && station.station.getColor() == color) return station;
        }
        return null;
    }

    private void addAllStation(ArrayList<NodeStation> stations) throws FileNotFoundException {
        File file = new File("src/Resources/StationList");
        Scanner scanner = new Scanner(file);
        String temp;
        String tempLine;
        COLOR tempColor;
        while (scanner.hasNextLine()) {
            temp = scanner.nextLine();

            if (temp.contains("линия") || temp.contains("ветка")) {
                tempLine = temp.replaceAll("(линия|ветка):", "").trim();
                tempColor = MetroLine.getECodeFromColor(tempLine);
                while (true) {
                    if (scanner.hasNextLine()) {
                        temp = scanner.nextLine();
                        if (temp.equals("") || temp.contains("линия") || temp.contains("ветка")) break;
                        stations.add(new NodeStation(new Station(temp, tempColor)));
                    } else break;

                }
            }
        }
        //stations.forEach(station -> System.out.println(station.getName() + " " + station.getColor()));
    }

    private void addAllMetroLine(ArrayList<MetroLine> Underground, ArrayList<NodeStation> stations) throws FileNotFoundException {

        MetroLine tempMetroLine = null;
        COLOR tempColor = COLOR.UNDEFINED;

        for (NodeStation station : stations) {

            if (tempColor != station.station.getColor()) {

                if (tempMetroLine != null)
                    Underground.add(tempMetroLine);
                tempColor = station.station.getColor();
                tempMetroLine = new MetroLine(MetroLine.getColorFromEcode(station.station.getColor()));
            }
            tempMetroLine.add(station);
        }
        Underground.add(tempMetroLine);
    }
}