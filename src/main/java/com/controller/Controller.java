package com.controller;

import com.model.Model;
import com.model.Note;
import com.view.Messages;
import com.view.View;

import java.util.Scanner;

public class Controller {
    private final Model model;
    private final View view;
    private final Scanner scanner = new Scanner(System.in);

    private final RegistrationService registrationService;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        registrationService = new RegistrationService(view);
    }

    public void process(){
        Note note = new Note();
        registerNote(note);
        addNote(note);
    }

    public void registerNote(Note note){
        registrationService.setScanner(scanner);
        registrationService.setNote(note);
        registrationService.process();
    }

    /**
     * This method adds note into model. If note has uncorrect field(s), this method fills this field(s) using custom
     * RegistrationService.
     * @see RegistrationService
     *
     * @param note - note to adding into model.
     */
    public void addNote(Note note){
        boolean status = false;
        while (!status){
            try {
                model.addNote(note);
                status = true;
            } catch (NicknameAlreadyUsedException e){
                view.printString(ResourceBundleManager.getString(Messages.nicknameAlreadyExist));
                registrationService.setNote(e.getNote());
                registrationService.fillNickname();
            }
        }
    }
}
