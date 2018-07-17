package controller;

import model.Attack;
import model.Pokemon;

import java.util.Scanner;

import static controller.IDisplayConsoleController.getStartMessage;
import static controller.IDisplayConsoleController.logp;
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
        opponentTurn = pkm1 == pokemonTurn ? pkm2 : pkm1;
        logp("pokemonTurn = " + pokemonTurn.getName());
        logp("opponnentTurn = " + opponentTurn.getName());

        //Start
        IDisplayConsoleController.refresh(getStartMessage(pkm2), true, pkm1, pkm2);
        scan();


        while(pkm1.getHp() > 0 && pkm2.getHp() > 0){

            msg = "What is " + pokemonTurn.getName() + " gonna do ?" + IDisplayConsoleController.getDisplayAttacks(pokemonTurn);
            IDisplayConsoleController.refresh(msg, false,pkm1, pkm2);
            PokemonController.chooseAttack(pokemonTurn, opponentTurn);

            msg = pokemonTurn.getName() + " uses " + Attack.choosenAttack.getName() + " !";
            IDisplayConsoleController.refresh(msg, true, pkm1, pkm2);
            pokemonTurn.use(Attack.choosenAttack, opponentTurn);

            changeIndexPlayer(pokemonTurn, opponentTurn);
            scan();

        }

    }

    public static void changeIndexPlayer (Pokemon pokemon, Pokemon opponent){
        pokemonTurn = (pokemonTurn == pokemon) ? (pokemonTurn = opponent) : (pokemonTurn = pokemon);
        opponentTurn = (opponentTurn == pokemon) ? (opponentTurn = opponent) : (opponentTurn = pokemon);
    }

    public static Pokemon getFastestPokemon(Pokemon pokemon, Pokemon opponent){
        if(pokemon.getSpe() == opponent.getSpe()){
            int random = (int)(Math.random() * (1-0));
            Pokemon fastestPokemon = random > 0 ? pokemon : opponent;
            return  fastestPokemon;
        }
        Pokemon fastestPokemon = pokemon.getSpe() > opponent.getSpe() ? pokemon : opponent;
        System.out.println("ici : " + fastestPokemon.getName());
        return fastestPokemon;
    }

    public static int scan(){
        Scanner sc = new Scanner(System.in);
        int scanNb = sc.nextInt();
        return scanNb;
    }
}