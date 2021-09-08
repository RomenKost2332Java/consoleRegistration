package com.controller;

import com.model.Group;
import com.model.Note;
import com.view.Messages;
import com.view.View;

import java.util.Scanner;

public class RegistrationService {
    private final View view;

    private Scanner scanner;
    private Note note;

    public RegistrationService(View view){
        this.view = view;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void process(){
        fillName();
        fillNickname();
        fillContacts();
        fillAddress();
    }

    public void fillName(){
        note.setSecondName(readString(
                ResourceBundleManager.getString(Regex.name),
                ResourceBundleManager.getString(Messages.getSecondName)
        ));
        note.setFirstName(readString(
                ResourceBundleManager.getString(Regex.name),
                ResourceBundleManager.getString(Messages.getFirstName)
        ));
        note.setThirdName(readString(
                ResourceBundleManager.getString(Regex.name),
                ResourceBundleManager.getString(Messages.getThirdName)
        ));
        note.generateName();
        note.setComment(readString(
                ResourceBundleManager.getString(Regex.any),
                ResourceBundleManager.getString(Messages.getComment)
        ));
    }

    public void fillContacts(){
        note.setGroup(validationGroup());
        note.setHomeNumber(readString(
                ResourceBundleManager.getString(Regex.homeNumber),
                ResourceBundleManager.getString(Messages.getHomeNumber)
        ));
        note.setFirstMobileNumber(readString(
                ResourceBundleManager.getString(Regex.firstMobileNumber),
                ResourceBundleManager.getString(Messages.getFirstMobileNumber)
        ));
        note.setSecondMobileNumber(readString(
                ResourceBundleManager.getString(Regex.secondMobileNumber),
                ResourceBundleManager.getString(Messages.getSecondMobileNumber)
        ));
        note.setEmail(readString(
                ResourceBundleManager.getString(Regex.email),
                ResourceBundleManager.getString(Messages.getEmail)
        ));
        note.setSkype(readString(
                ResourceBundleManager.getString(Regex.nickname),
                ResourceBundleManager.getString(Messages.getSkype)
        ));
    }

    public void fillAddress(){
        note.setPostIndex(Integer.parseInt(readString(
                ResourceBundleManager.getString(Regex.index),
                ResourceBundleManager.getString(Messages.getIndex)
        )));
        note.setCity(readString(
                ResourceBundleManager.getString(Regex.nameWithDigits),
                ResourceBundleManager.getString(Messages.getCity)
        ));
        note.setStreet(readString(
                ResourceBundleManager.getString(Regex.nameWithDigits),
                ResourceBundleManager.getString(Messages.getStreet)
        ));
        note.setHouse(readString(
                ResourceBundleManager.getString(Regex.house),
                ResourceBundleManager.getString(Messages.getHouse)
        ));
        note.setFlat(readString(
                ResourceBundleManager.getString(Regex.flat),
                ResourceBundleManager.getString(Messages.getFlat)
        ));
        note.generateFullAddress();
    }

    private String validationGroup(){
        String group = readString(
                ResourceBundleManager.getString(Regex.any),
                ResourceBundleManager.getString(Messages.getGroup)
        );
        while (!Group.contain(group)){
            view.printString(ResourceBundleManager.getString(Messages.wrongInput));
            group = readString(Regex.any, Messages.getGroup);
        }
        return group;
    }

    public void fillNickname(){
        note.setNickname(readString(
                        ResourceBundleManager.getString(Regex.nickname),
                        ResourceBundleManager.getString(Messages.getNickname)
        ));
    }

    private String readString(String pattern, String inputMessage){
        view.printString(inputMessage);

        String res;
        while (!scanner.hasNext() || !(res = scanner.next()).matches(pattern)) {
            view.printString(ResourceBundleManager.getString(Messages.wrongInput) + inputMessage);
        }
        return res;
    }
}
