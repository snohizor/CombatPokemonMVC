package controller;

import model.Attack;
import model.Pokemon;

import java.util.ArrayList;

public class GameController {

    public static Double factor = 1D;
    public Pokemon pkmn1 = Pokemon.pkm1;
    public Pokemon pkmn2 = Pokemon.pkm2;
    Attack charge = new Attack("charge", 40, 95); // TODO: 04/07/2018 déplacer dans le data
    //ArrayList atksBulbi = Pokemon.getAtksBulbi(); // TODO: 04/07/2018 faire appel à une méthode du data




    public static void logp(String msg){
        System.out.println(msg);
    }

    public static void fight(Pokemon pokemon, Pokemon opponent){
        while (pokemon.getHp() > 0 && opponent.getHp() > 0){
            // TODO: 04/07/2018 fight
            pokemon.attack(1, opponent);
            Pokemon tmp = pokemon;
            pokemon = opponent;
            opponent = tmp;
        }
    }
}

