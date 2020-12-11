package com.mypackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StationContainerInit {
    void initUnderground() throws FileNotFoundException {
        ArrayList<Station> stations = new ArrayList<>();
        ArrayList<MetroLine> Underground = new ArrayList<>();

        addAllStation(stations);
        addAllMetroLine(Underground);

        //Underground.stream().forEach(stations -> stations.info());


//    MetroLine RedLine = Underground.get(0);
//    MetroLine GreenLine = Underground.get(1);
//    MetroLine BlueLine = Underground.get(2);
//    MetroLine SkyLine = Underground.get(3);
//    MetroLine BrownLine = Underground.get(4);
//    MetroLine OrangeLine = Underground.get(5);
//    MetroLine Violetline = Underground.get(6);
//    MetroLine YellowSunLine = Underground.get(7);
//    MetroLine YellowKalinynLine = Underground.get(8);
//    MetroLine GrayLine = Underground.get(9);
//    MetroLine LightGreenLine = Underground.get(10);
//    MetroLine AzureLine = Underground.get(11);
//    MetroLine LightBlueLine = Underground.get(12);
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
    }

    void addAllStation(ArrayList<Station> stations) throws FileNotFoundException {
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
                        stations.add(new Station(temp,tempColor));
                    }

                    else break;

                }
            }
        }
        stations.forEach(station -> System.out.println(station.getName() + " " + station.getColor()));
    }

    void addAllMetroLine(ArrayList<MetroLine> Underground) throws FileNotFoundException {
        File file = new File("src/Resources/StationList");
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
    }




    boolean addTrans(MetroLine metroLine1, String name1, MetroLine metroLine2, String name2) {
        metroLine1.getNodeStation(name1).addTransStation(metroLine2.getNodeStation(name2));
        return true;
    }
}
