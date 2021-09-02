package com.controller;

import com.model.Group;
import com.model.Note;
import com.view.Languages;
import com.view.View;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class RegistrationService {
    private static final String RESOURCE_BUNDLE_NAME = "messages";

    private final Note note;
    private final View view;

    private final Scanner scanner;

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, new Locale(Languages.UA));

    public RegistrationService(Note note, View view, Scanner scanner){
        this.note = note;
        this.view = view;
        this.scanner = scanner;
    }

    public void process(){
        note.setFirstName(readString(Regex.name));
        note.setSecondName(readString(Regex.name));
        note.setThirdName(readString(Regex.name));
        note.generateName();

        note.setNickname(readString(Regex.nickname));
        note.setComment(readString(Regex.any));
        note.setGroup(validationGroup());

        note.setHomeNumber(readString(Regex.homeNumber));
        note.setFirstMobileNumber(readString(Regex.firstMobileNumber));
        note.setSecondMobileNumber(readString(Regex.secondMobileNumber));

        note.setEmail(readString(Regex.email));
        note.setSkype(readString(Regex.nickname));

        note.setPostIndex(Integer.parseInt(readString(Regex.index)));
        note.setCity(Regex.nameWithDigits);
        note.setStreet(Regex.nameWithDigits);
        note.setHouse(Regex.house);
        note.setFlat(Regex.flat);

        note.generateFullAddress();
    }

    private String validationGroup(){
        String group = readString(Regex.any);
        while (!Group.contain(group)){
            group = readString(Regex.any);
        }
        return group;
    }

    private String readString(String patternName){
        while (!scanner.hasNext(resourceBundle.getString(patternName))){
            scanner.next();
        }
        return scanner.nextLine();
    }
}
