package controller;


import javafx.beans.DefaultProperty;
import model.Pokemon;

import java.util.Scanner;

import static controller.GameController.maxLogLength;

public interface IDisplayController {



    static void refresh(Pokemon pokemon, Pokemon opponent){
        clearScreen();
        displayFightScene(pokemon, opponent);
        displayMessage(pokemon, opponent);
    }

    static void displayMessage(Pokemon pokemon, Pokemon opponent) {
        logp(PROP.getProperties);
    }


    static void displayFightScene(Pokemon pokemon, Pokemon opponent){
        writeLine();
        int spacesFirstLine = maxLogLength - opponent.getName().length() - 1;
        int spacesSecondLine = maxLogLength - getLife(opponent).length() - 1;
        logp(writeSpace(spacesFirstLine) + opponent.getName()
                + "\n" + writeSpace(spacesSecondLine) + getLife(opponent)
                + "\n\n"
                + "\n " + pokemon.getName()
                + "\n "+ getLife(pokemon)
                );
        writeLine();
    }

    static String getLife(Pokemon pokemon){
        return pokemon.getHp() + "/" + pokemon.getHpMax();
    }

    static void displayStart(Pokemon pokemon, Pokemon opponent){

    }

    static void displayStats(Pokemon pokemon, Pokemon opponent){

    }

    static String writeSpace(int spaces){
        String packageOfSpaces = "";
        for(int i=0; i<spaces; i++)
            packageOfSpaces = packageOfSpaces + " ";
        return packageOfSpaces;
    }

    static void writeLine(){
        String packageOfDashes = "";
        for(int i=0; i<maxLogLength; i++)
            packageOfDashes = packageOfDashes + "-";
        logp(packageOfDashes);
    }

    static void displayStats(Pokemon pokemon){
        logp("-------");
        logp(pokemon.getName());
        logp("hp : " + pokemon.getHp() + "/" + pokemon.getHpMax());
        logp("atk: " + pokemon.getAtk());
        logp("def: " + pokemon.getDef());
        logp("sat: " + pokemon.getSat());
        logp("sde: " + pokemon.getSde());
        logp("spe: " + pokemon.getSpe());
        logp("-------");
    }

    static int choice(){
        Scanner sc = new Scanner(System.in);
        int scan = sc.nextInt();
        return scan;
    }

    static void clearScreen() {
        for(int i=0; i < 5; i++)
            logp("");
    }

    static void logp(String msg){
        System.out.println(msg);
    }

}
