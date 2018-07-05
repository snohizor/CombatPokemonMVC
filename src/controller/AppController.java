package controller;

import view.Frame;

import static controller.GameController.logp;

public class AppController {
    private Frame appFrame;

    public void start(){
        appFrame = new Frame(this);
    }

    public static void clearScreen() {
        for(int i=0; i < 50; i++)
            logp("");
    }
}
