package com.mypackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MetroLine {
    private COLOR color;
    private String name;

    NodeStation Head;
    NodeStation Tail;
    NodeStation CurrentStation;

    void initStationList() {
        Head = new NodeStation(new Station("",COLOR.UNDEFINED));
        Tail = new NodeStation(new Station("",COLOR.UNDEFINED));
    }

    Set<COLOR> colorSwitchSet = new HashSet<>();

    public MetroLine(String name) {
        this.name = name;
        setColor(name);
        initStationList();
    }

    public String getName() {
        return name;
    }

    public COLOR getColor() {
        return color;
    }

    boolean add(Station station) {
        NodeStation temp = new NodeStation(station);
        if (!Head.hasNext()) {
            Head.setNext(temp);
        }
        CurrentStation = Tail;
        CurrentStation.setNext(temp);
        Tail = temp;
        Tail.setPrev(CurrentStation);
        return true;
    }

    private void setColor(String name) {
        color = getECodeFromColor(name);
    }

    static COLOR getECodeFromColor(String name) {
        COLOR color;
        switch (name) {
            case "Сокольническая" -> color = COLOR.RED;
            case "Филевская" -> color = COLOR.SKY;
            case "Арбатско-Покровская" -> color = COLOR.BLUE;
            case "Серпуховско-Тимирязевская" -> color = COLOR.GRAY;
            case "Каховская" -> color = COLOR.AZURE;
            case "Кольцевая" -> color = COLOR.BROWN;
            case "Замоскворецкая" -> color = COLOR.GREEN;
            case "Калужско-Рижская" -> color = COLOR.ORANGE;
            case "Таганско-Краснопресненская" -> color = COLOR.VIOLET;
            case "Солнцевская" -> color = COLOR.YELLOW_SUN;
            case "Калининская" -> color = COLOR.YELLOW_KALININSKAYA;
            case "Бутовская" -> color = COLOR.LIGHT_BLUE;
            case "Люблинско-Дмитровская" -> color = COLOR.LIGHT_GREEN;
            default -> color = COLOR.UNDEFINED;
        }
        return color;
    }

    static String getColorFromEcode(COLOR color) {
        String name;
        switch (color) {
            case RED -> name = "Сокольническая" ;
            case SKY -> name = "Филевская";
            case BLUE -> name = "Арбатско-Покровская";
            case GRAY -> name = "Серпуховско-Тимирязевская";
            case AZURE -> name = "Каховская";
            case BROWN -> name = "Кольцевая";
            case GREEN -> name = "Замоскворецкая";
            case ORANGE -> name = "Калужско-Рижская";
            case VIOLET -> name = "Таганско-Краснопресненская";
            case YELLOW_KALININSKAYA -> name = "Калининская";
            case YELLOW_SUN -> name = "Солнцевская";
            case LIGHT_BLUE -> name = "Бутовская";
            case LIGHT_GREEN -> name = "Люблинско-Дмитровская";
            default -> name = "";
        }
        return name;
    }


    void info() {
        System.out.println("" +
                name + " линия." + " цвет: =" + color +
                ", Возможны пересадки на ветки: " + colorSwitchSet +
                '}');
        CurrentStation = Head;
        do {
            CurrentStation = CurrentStation.getNext();
            System.out.println("\t" + CurrentStation);
        } while (CurrentStation.hasNext());
        System.out.println();
    }

    NodeStation getNodeStation(String name) {
        CurrentStation = Head;
        do {
            CurrentStation = CurrentStation.getNext();
            if (CurrentStation.station.getName().equals(name)) return CurrentStation;
        } while (CurrentStation.hasNext());
        return null;
    }

    @Override
    public String toString() {
        return "MetroLine{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", colorSwitchSet=" + colorSwitchSet +
                '}';
    }
}
