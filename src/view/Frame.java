package view;

import controller.AppController;

import javax.swing.*;

public class Frame extends JFrame {
    private Panel basePanel;
    public Frame(AppController baseController){
        basePanel = new Panel(baseController);
        setupFrame();
    }

    private void setupFrame(){
        this.setContentPane(basePanel);
        this.setSize(500,400);
        this.setVisible(true);
    }
}
