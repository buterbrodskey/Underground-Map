package com.mypackage;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            new StationContainerInit().initUnderground();
        } catch (FileNotFoundException e) {
        }


    }
}
