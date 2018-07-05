package controller;

import model.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;

import static controller.GameController.logp;

public class PokemonController {

    final static int maxLogLength = 26;
    private static final Arrays tempStatNamesArrays = null; //TODO: demander a un expert
    private static final Arrays tempStatValues1 = null; //TODO: demander a un expert
    private static final Arrays tempStatValues2 = null; //TODO: demander a un expert


    public static void displayTitle(Pokemon pokemon, Pokemon opponent){
        //attention chuttes de vomi
        writeLine();
        int totalSpacesNeeded = maxLogLength - (pokemon.getName() + " vs " + opponent.getName()).length();
        int halfTotalSpacesNeeded = totalSpacesNeeded / 2 + 1;
        logp(writeSpace(halfTotalSpacesNeeded) + pokemon.getName() + " vs " + opponent.getName());
        writeLine();

        //cancer TODO:clean
        ArrayList<String> statsNamesList = new ArrayList<>();
        ArrayList<Integer> statsValuesList1 = new ArrayList<>();
        ArrayList<Integer> statsValuesList2 = new ArrayList<>();
        statsNamesList.addAll(tempStatNamesArrays.asList("atk","def","sat","sde","spe"));
        statsValuesList1.addAll(tempStatValues1.asList(pokemon.getAtk(), pokemon.getDef(), pokemon.getSat(), pokemon.getSde(), pokemon.getSpe()));
        statsValuesList2.addAll(tempStatValues2.asList(opponent.getAtk(), opponent.getDef(), opponent.getSat(), opponent.getSde(), opponent.getSpe()));

        //Ya pas mieux ?
        String hpDisplayTEMP = pokemon.getHp() + "/" + pokemon.getHpMax() + opponent.getHp() + "/" + opponent.getHpMax();
        String hpDisplay = pokemon.getHp() + "/" + pokemon.getHpMax() + writeSpace((maxLogLength - hpDisplayTEMP.length()) / 2 - 2)
                + opponent.getHp() + "/" + opponent.getHpMax();


        logp(writeSpace((maxLogLength - hpDisplay.length()) / 2) + hpDisplay);
        writeLine();

        int i = 0;
        for (String stat : statsNamesList){
            logp(writeSpace((maxLogLength - 18) / 2) + statsNamesList.get(i) + writeSpace(
                    3 - (Integer.toString(statsValuesList1.get(i))).length())
                    + statsValuesList1.get(i) + writeSpace(4) + stat + ":" + writeSpace(
                    3 - (Integer.toString(statsValuesList2.get(i))).length()) + statsValuesList2.get(i));
            i++;
        }
    }

    public static String writeSpace(int spaces){
        String packageOfSpaces = "";
        for(int i=0; i<spaces; i++)
            packageOfSpaces = packageOfSpaces + " ";
        return packageOfSpaces;
    }

    public static void writeLine(){
        String packageOfDashes = "";
        for(int i=0; i<maxLogLength; i++)
            packageOfDashes = packageOfDashes + "-";
        logp(packageOfDashes);
    }

    public static void displayStats(Pokemon pokemon){
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
}
