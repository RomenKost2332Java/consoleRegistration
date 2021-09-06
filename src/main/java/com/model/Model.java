package com.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Note> notebook = new ArrayList<>();

    public void addNote(Note note){
        notebook.add(note);
        note.setAddDate();
    }

    public List<Note> getNotebook() {
        return new ArrayList<>(notebook);
    }
}
