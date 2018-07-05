package controller;

import model.Pokemon;

import static controller.GameController.logp;

public class AppRunner {
    public static void main(String[] args){
        AppController baseApp = new AppController();
        //baseApp.start();

        logp("START");
        Pokemon pkm1 = new GameController().pkmn1;
        Pokemon pkm2 = new GameController().pkmn2;

        //GameController.fight(pkm1, pkm2);

        pkm1.displayStats();
        pkm2.displayStats();

    }
}
