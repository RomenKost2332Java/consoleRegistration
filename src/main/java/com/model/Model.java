package com.model;

import com.controller.NicknameAlreadyUsedException;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private final List<Note> notebook = new ArrayList<>();

    /**
     * This method adds note into notebook and checks on correct all fields, that depends another elements of notebook,
     *
     * @param note - note to adding in the notebook.
     * @throws NicknameAlreadyUsedException - if the notebook has note with the same nickname.
     */
    public void addNote(Note note) throws NicknameAlreadyUsedException{
        if(hasNickname(note.getNickname())){
            throw new NicknameAlreadyUsedException(note);
        }
        notebook.add(note);
        note.setAddDate();
    }

    public List<Note> getNotebook() {
        return new ArrayList<>(notebook);
    }

    public boolean hasNickname(String nickname){
        return notebook.stream()
                .anyMatch(note ->
                        nickname.equals(note.getNickname())
                );
    }
}
