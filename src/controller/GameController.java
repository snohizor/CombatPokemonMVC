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
        pokemonTurn = pkm1;
        pokemonTurn = (pokemon.getSpe() > opponent.getSpe()) ? pokemon : opponent;
        opponentTurn = (opponent.getSpe() > pokemon.getSpe()) ? pokemon : opponent;

        IDisplayController.refresh(pkm1, pkm2);
    }

    public static void changeIndexPlayer (Pokemon pokemon, Pokemon opponent){
        pokemonTurn = (pokemonTurn == pokemon) ? (pokemonTurn = opponent) : (pokemonTurn = pokemon);
    }

    public static int scan(){
        Scanner sc = new Scanner(System.in);
        int scanNb = sc.nextInt();
        return scanNb;
    }
}