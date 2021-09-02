package com;

import com.controller.Controller;
import com.model.Model;
import com.view.View;

public class Main {
    public static void main(String... args){
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        controller.process();
    }
}
