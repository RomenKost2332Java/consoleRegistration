package com.controller;

public class NicknameAlreadyUsedException extends RuntimeException {
    private final String nickname;

    public NicknameAlreadyUsedException(String nickname){
        super();
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
