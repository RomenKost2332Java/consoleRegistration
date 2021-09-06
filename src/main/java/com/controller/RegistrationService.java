package com.controller;

import com.model.Group;
import com.model.Note;
import com.view.Messages;
import com.view.View;

import java.util.Scanner;

public class RegistrationService {

    private final Note note;
    private final View view;

    private final Scanner scanner;

    public RegistrationService(Note note, View view, Scanner scanner){
        this.note = note;
        this.view = view;
        this.scanner = scanner;
    }

    public void process(){
        note.setSecondName(readString(Regex.name, Messages.getSecondName));
        note.setFirstName(readString(Regex.name, Messages.getFirstName));
        note.setThirdName(readString(Regex.name, Messages.getThirdName));
        note.generateName();

        note.setNickname(readString(Regex.nickname, Messages.getNickname));
        note.setComment(readString(Regex.any, Messages.getComment));
        note.setGroup(validationGroup());

        note.setHomeNumber(readString(Regex.homeNumber, Messages.getHomeNumber));
        note.setFirstMobileNumber(readString(Regex.firstMobileNumber, Messages.getFirstMobileNumber));
        note.setSecondMobileNumber(readString(Regex.secondMobileNumber, Messages.getSecondMobileNumber));

        note.setEmail(readString(Regex.email, Messages.getEmail));
        note.setSkype(readString(Regex.nickname, Messages.getSkype));

        note.setPostIndex(Integer.parseInt(readString(Regex.index, Messages.getIndex)));
        note.setCity(readString(Regex.nameWithDigits, Messages.getCity));
        note.setStreet(readString(Regex.nameWithDigits, Messages.getStreet));
        note.setHouse(readString(Regex.house, Messages.getHouse));
        note.setFlat(readString(Regex.flat, Messages.getFlat));

        note.generateFullAddress();
    }

    private String validationGroup(){
        String group = readString(Regex.any, Messages.getGroup);
        while (!Group.contain(group)){
            view.printString(ResourceBundleManager.getString(Messages.wrongInput));
            group = readString(Regex.any, Messages.getGroup);
        }
        return group;
    }

    private String readString(String pattern, String inputMessage){
        pattern = ResourceBundleManager.getString(pattern);
        inputMessage = ResourceBundleManager.getString(inputMessage);
        view.printString(inputMessage);

        String res;
        while (!scanner.hasNext() || !(res = scanner.next()).matches(pattern)) {
            view.printString(ResourceBundleManager.getString(Messages.wrongInput) + inputMessage);
        }
        return res;
    }
}
