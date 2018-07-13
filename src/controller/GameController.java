package controller;

import model.Pokemon;

import java.util.Scanner;

import static model.Pokemon.pkm1;
import static model.Pokemon.pkm2;

public class GameController {

    public static double factor = 1D;
    public static Pokemon pokemonTurn;
    public static Pokemon opponentTurn;

    static String msg = "voila pour l instant ca sera ca lol";


    final static int maxLogLength = 26;

    public static void fight(Pokemon pokemon, Pokemon opponent) {
        //Start
        /*IDisplayConsoleController.displayFightScene(pokemon, opponent);
        IDisplayConsoleController.displayStart(pokemon, opponent);
        scan();*/

        //Setup
        pokemonTurn = getFastestPokemon(pokemon, opponent);
        opponentTurn = (opponent.getSpe() > pokemon.getSpe()) ? pokemon : opponent;

        //Start
        IDisplayConsoleController.refresh(getStartMessage(pkm1, pkm2), pkm1, pkm2);
        scan();

        while(pkm1.getHp() > 0 && pkm2.getHp() > 0){
            msg = "What is " + pokemonTurn.getName() + " gonna do ?";
            IDisplayConsoleController.refresh(msg, pkm1, pkm2);
            System.out.println("you chooz " + scan());
        }

    }

    public static void changeIndexPlayer (Pokemon pokemon, Pokemon opponent){
        pokemonTurn = (pokemonTurn == pokemon) ? (pokemonTurn = opponent) : (pokemonTurn = pokemon);
    }

    public static String getStartMessage(Pokemon pokemon, Pokemon opponent){
        return opponent.getName() + " wants to fight !";
    }

    public static Pokemon getFastestPokemon(Pokemon pokemon, Pokemon opponent){
        Pokemon fastestPokemon = pokemon.getSpe() > opponent.getSpe() ? pokemon : opponent;
        return fastestPokemon;
    }

    public static int scan(){
        Scanner sc = new Scanner(System.in);
        int scanNb = sc.nextInt();
        return scanNb;
    }
}