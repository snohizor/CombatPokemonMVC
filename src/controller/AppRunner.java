package controller;

import model.Pokemon;

public class AppRunner {
    public static void main(String[] args){
        AppController baseApp = new AppController();
        //baseApp.start();

        Pokemon pkm1 = new PokemonController().pkmn1;
        Pokemon pkm2 = new PokemonController().pkmn2;

        IDisplayConsoleController.displayMessage(pkm1, pkm2);

        GameController.fight(pkm1, pkm2);

    }

}
