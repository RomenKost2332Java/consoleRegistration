package com.model;

import com.controller.NicknameAlreadyUsedException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {
    private static final Model model = new Model();

    private static final String nickname1 = "Nickname1";
    private static final String nickname2 = "Nickname2";

    @BeforeClass
    public static void initializationModel(){
        Note note = new Note();
        note.setNickname(nickname1);
        model.addNote(note);
    }

    @Test
    public void hasNicknameTest(){
        Assert.assertTrue(model.hasNickname(nickname1));
        Assert.assertFalse(model.hasNickname(nickname2));
    }

    @Test(expected = NicknameAlreadyUsedException.class)
    public void setNicknameTest(){
        Note note = new Note();
        note.setNickname(nickname1);
        model.addNote(note);
    }

}
