package view;

import controller.AppController;

import javax.swing.*;

public class Panel extends JPanel {
    private AppController baseController;
    public Panel(AppController baseController){
        this.baseController = baseController;
    }
}
