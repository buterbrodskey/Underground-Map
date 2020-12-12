package com.mypackage;

public class StationFindException extends Exception {
    public StationFindException(String message) {
        super(message);
        System.out.println(message);
    }
}
