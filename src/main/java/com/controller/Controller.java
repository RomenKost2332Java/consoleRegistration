package com.controller;

import com.model.Model;
import com.view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void process(){

    }
}
