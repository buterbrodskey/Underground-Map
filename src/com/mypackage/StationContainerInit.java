package com.mypackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StationContainerInit {
    void initUnderground() throws FileNotFoundException {
        ArrayList<Station> stationArrayList = new ArrayList<>();
        File file = new File("src/Resources/StationList");
        ArrayList<MetroLine> Underground = new ArrayList<>();
        Scanner scanner = new Scanner(file);



        MetroLine tempMetroLine;
        String temp;
        String tempLine;
        int i = 0;

        while (scanner.hasNextLine()) {
            temp = scanner.nextLine();


                if (temp.contains("линия") || temp.contains("ветка")) {
                    tempLine = temp.replaceAll("(линия|ветка):", "").trim();
                    tempMetroLine = new MetroLine(tempLine);
                    while (true) {
                        if (scanner.hasNextLine())
                        temp = scanner.nextLine();
                        else break;

                        if (temp.equals("")|| temp.contains("линия") || temp.contains("ветка")) break;

                        else tempMetroLine.add(new Station(temp,MetroLine.getECodeFromColor(tempLine)));

                }
                    Underground.add(tempMetroLine);
            }
        }

        //Underground.stream().forEach(stations -> stations.info());


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

        addTrans(RedLine,"Парк Культуры",BrownLine, "Парк Культуры");

        addTrans(RedLine,"Библиотека имени Ленина",BlueLine, "Арбатская");
        addTrans(RedLine,"Библиотека имени Ленина",GrayLine, "Боровицкая");
        addTrans(RedLine,"Библиотека имени Ленина",SkyLine, "Александровский сад");

        addTrans(RedLine,"Охотный ряд",GreenLine, "Театральная");
        addTrans(RedLine,"Охотный ряд",BlueLine, "Площадь Революции");

        addTrans(RedLine,"Лубянка",Violetline, "Кузнецкий мост");

        addTrans(RedLine,"Чистые пруды",LightGreenLine, "Сретенский бульвар");
        addTrans(RedLine,"Чистые пруды",OrangeLine, "Тургеневская");

        addTrans(RedLine,"Комсомольская",BrownLine, "Комсомольская");

        RedLine.info();
    }
    boolean addTrans(MetroLine<Station> metroLine1, String name1, MetroLine<Station> metroLine2, String name2) {
        for (int i = 0; i < metroLine1.size(); i++) {
            if (metroLine1.get(i).getName().equals(name1)) {
                for (int i1 = 0; i1 < metroLine2.size(); i1++) {
                    if (metroLine2.get(i1).getName().equals(name2)) {
                        metroLine1.get(i).addTransStation(metroLine2.get(i1).getName());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
