package controller;

import model.Pokemon;

import java.util.Scanner;

import static model.Pokemon.pkm1;
import static model.Pokemon.pkm2;

public class GameController {

    public static double factor = 1D;
    public static Pokemon pokemonTurn;
    public static Pokemon opponentTurn;


    final static int maxLogLength = 26;

    public static void fight(Pokemon pokemon, Pokemon opponent) {
        pokemonTurn = getFastestPokemon(pokemon, opponent);
        opponentTurn = (opponent.getSpe() > pokemon.getSpe()) ? pokemon : opponent;

        IDisplayConsoleController.refresh(pkm1, pkm2);


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