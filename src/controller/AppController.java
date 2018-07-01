package controller;

import view.Frame;

public class AppController {
    private Frame appFrame;
    public void start(){
        appFrame = new Frame(this);
    }
}
