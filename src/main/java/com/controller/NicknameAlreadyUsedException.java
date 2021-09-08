package com.controller;

import com.model.Note;

public class NicknameAlreadyUsedException extends RuntimeException {
    private final Note note;

    public NicknameAlreadyUsedException(Note note){
        super();
        this.note = note;
    }

    public Note getNote() {
        return note;
    }
}
