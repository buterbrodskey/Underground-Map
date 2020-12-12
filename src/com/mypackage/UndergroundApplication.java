package com.mypackage;

import java.util.ArrayList;
import java.util.Scanner;

public class UndergroundApplication {
    ArrayList<MetroLine> underground = new StationContainerInit().initUnderground();
    void start() {
        Scanner scanner = new Scanner(System.in);
        String rootLine;
        String rootStation;
        String transferLine;
        String transferStation;
        do {
            rootLine = scanner.nextLine();
            rootStation = scanner.nextLine();
            transferLine = scanner.nextLine();
            transferStation = scanner.nextLine();
        } while (rootLine.equals("")||rootStation.equals("")||transferLine.equals("")||transferStation.equals(""));




    }
}
