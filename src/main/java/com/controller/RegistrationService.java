package com.controller;

import com.model.Group;
import com.model.Model;
import com.model.Note;
import com.view.Messages;
import com.view.View;

import java.util.Scanner;

public class RegistrationService {
    private final View view;
    private final Model model;

    private Scanner scanner;
    private Note note;

    public RegistrationService(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public void process(){
        setName();
        setContacts();
        setAddress();
    }

    public void setName(){
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
    }

    public void setContacts(){
        note.setComment(readString(
                ResourceBundleManager.getString(Regex.any),
                ResourceBundleManager.getString(Messages.getComment)
        ));
        setNickname();
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

    public void setAddress(){
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

    private void setNickname(){
        boolean status = false;
        while (!status){
            try {
                note.setNickname(readString(
                        ResourceBundleManager.getString(Regex.nickname),
                        ResourceBundleManager.getString(Messages.getNickname)
                ), model);
                status = true;
            } catch (NicknameAlreadyUsedException e){
                view.printString(ResourceBundleManager.getString(Messages.nicknameAlreadyExist));
            }
        }
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
