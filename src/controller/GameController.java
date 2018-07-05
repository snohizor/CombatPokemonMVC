package controller;

import model.Attack;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static controller.AppController.clearScreen;
import static model.Attack.lastAttackDone;
import static model.Pokemon.pkm1;

public class GameController {

    public static double factor = 1D;
    public static Pokemon pokemonTurn;
    public static Pokemon opponentTurn;
    public static int scan;


    final static int maxLogLength = 26;
    private static final Arrays tempStatNamesArrays = null; //TODO: demander a un expert
    private static final Arrays tempStatValues1 = null; //TODO: demander a un expert
    private static final Arrays tempStatValues2 = null; //TODO: demander a un expert

    public static void fight(Pokemon pokemon, Pokemon opponent){
        pokemonTurn = pkm1;
        clearScreen();
        displayStart(pokemon, opponent);
        pressAnyKeyToContinue();
        pokemonTurn = (pokemon.getSpe() > opponent.getSpe()) ? pokemon : opponent;
        opponentTurn = (opponent.getSpe() > pokemon.getSpe()) ? pokemon : opponent;

        while (pokemon.getHp() > 0 && opponent.getHp() > 0){
            clearScreen();
            logp("bruh 1");
            displayFight(pokemon, opponent);
            logp("bruh 2");
            pokemonTurn.chooseAttack();
            clearScreen();
            logp("bruh 3");
            displayAttack(pokemonTurn, opponentTurn, lastAttackDone);
            logp("bruh 4");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
            logp("bruh 5");
            pokemonTurn.attack(opponentTurn);
            logp("bruh 6");
            displayAttack(pokemonTurn, opponentTurn, lastAttackDone);
            logp("bruh 7");

            changeIndexPlayer(pokemonTurn, opponentTurn);
        }
    }

    public static int scan(){
        Scanner sc = new Scanner(System.in);
        scan = sc.nextInt();
        return scan;
    }

    private static void pressAnyKeyToContinue()
    {
        System.out.println("press any key to continue");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    public static void changeIndexPlayer(Pokemon pokemon, Pokemon opponent){
        pokemonTurn = (pokemonTurn == pokemon) ? (pokemonTurn = opponent) : (pokemonTurn = pokemon);
    }

    /**
     *
     * DISPLAYS
     *
     * @param pokemon
     * @param opponent
     */
    public static void displayFight(Pokemon pokemon, Pokemon opponent){
        displayPlayingPokemon();
        displayFightZone(pokemon, opponent);
        logp("What are you gonna do ?");
        logp("1:" + pokemon.getAtksList().get(0).getName() + writeSpace(11 - pokemon.getAtksList().get(0).getName().length())
            + "3:" + pokemon.getAtksList().get(2).getName());
        logp("2:" + pokemon.getAtksList().get(1).getName() + writeSpace(11 - pokemon.getAtksList().get(1).getName().length())
                + "4:" + pokemon.getAtksList().get(3).getName());
        writeLine();
    }

    public static void displayAttack(Pokemon pokemon, Pokemon opponent, Attack attack){
        displayFightZone(pokemon, opponent);
        logp(pokemon.getName() + " uses \n" + attack.getName() + " !");
    }

    private static void displayFightZone(Pokemon pokemon, Pokemon opponent) {
        writeLine();
        int upperSpacesNb = maxLogLength - getLife(opponent).length() - 1 - opponent.getName().length();
        logp(writeSpace(upperSpacesNb) + opponent.getName() + " " + getLife(opponent));
        logp(writeSpace(maxLogLength));
        logp(pokemon.getName() + " " + getLife(pokemon));
        writeLine();
    }

    public static void displayPlayingPokemon(){
        logp("Playing : " + pokemonTurn.getName());
    }

    public static String getLife(Pokemon pokemon){
        return pokemon.getHp() + "/" + pokemon.getHpMax();
    }

    public static void displayStart(Pokemon pokemon, Pokemon opponent){
        displayFightZone(pokemon, opponent);
        logp(opponent.getName() + " wants to fight !\n\n");
        writeLine();
    }

    public static void displayStats(Pokemon pokemon, Pokemon opponent){
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
        writeLine();
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



    public static void logp(String msg){
        System.out.println(msg);
    }
}