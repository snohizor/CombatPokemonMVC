package controller;

import model.Attack;
import model.Pokemon;

import java.util.Scanner;

import static controller.IDisplayConsoleController.displayFightScene;
import static controller.IDisplayConsoleController.getStartMessage;
import static model.Pokemon.pkm1;
import static model.Pokemon.pkm2;

public class GameController {

    public static double factor = 1D;
    public static Pokemon pokemonTurn;
    public static Pokemon opponentTurn;
    public static int choice;

    static public String msg = "voila pour l instant ca sera ca lol";

    final static int maxLogLength = 26;

    public static void fight(Pokemon pokemon, Pokemon opponent) {
        //Setup
        pokemonTurn = getFastestPokemon(pokemon, opponent);
        opponentTurn = getFastestPokemon(opponent, pokemon);

        //Start
        IDisplayConsoleController.refresh(getStartMessage(pkm2), pkm1, pkm2);
        scan();


        while(pkm1.getHp() > 0 && pkm2.getHp() > 0){

            msg = "What is " + pokemonTurn.getName() + " gonna do ?" + IDisplayConsoleController.getDisplayAttacks(pokemonTurn);
            IDisplayConsoleController.refresh(msg, pkm1, pkm2);
            PokemonController.chooseAttack(pokemonTurn, opponentTurn);
            IDisplayConsoleController.refresh(msg, pkm1, pkm2);
            pokemonTurn.use(Attack.lastAttackDone, opponentTurn);

            changeIndexPlayer(pokemonTurn, opponentTurn);
        }

    }

    public static void changeIndexPlayer (Pokemon pokemon, Pokemon opponent){
        pokemonTurn = (pokemonTurn == pokemon) ? (pokemonTurn = opponent) : (pokemonTurn = pokemon);
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