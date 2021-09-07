package com.view;

import java.io.PrintStream;

public class View {
    private final PrintStream out;

    public View(){
        out = System.out;
    }

    public View(PrintStream printStream){
        out = printStream;
    }

    public void printString(String message){
        out.print(message);
    }
}
