package com.view;

public class View {
    public void printString(String message, Object... args){
        System.out.printf(message, args);
    }

    public void printString(String message){
        System.out.print(message);
    }
}
