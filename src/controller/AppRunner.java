package controller;

import model.Pokemon;

import static controller.GameController.logp;

public class AppRunner {
    public static void main(String[] args){
        AppController baseApp = new AppController();
        //baseApp.start();

        Pokemon pkm1 = new PokemonController().pkmn1;
        Pokemon pkm2 = new PokemonController().pkmn2;

        GameController.fight(pkm1, pkm2);

    }

}
