package com.controller;

import com.model.Model;
import com.model.Note;
import com.view.View;

import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;
    private final Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void process(){
        Note note = new Note();
        registerNote(note);
    }

    public void registerNote(Note note){
        RegistrationService registrationService = new RegistrationService(note, view, scanner);
        registrationService.process();
        model.addNote(note);
    }
}
