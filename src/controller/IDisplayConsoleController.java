package controller;

import model.Pokemon;

import java.util.Scanner;

import static controller.GameController.maxLogLength;
import static controller.GameController.msg;

public interface IDisplayConsoleController {

    static void refresh(String msg, Pokemon pokemon, Pokemon opponent){
        clearScreen();
        displayFightScene(pokemon, opponent);
        displayMessage(msg, pokemon, opponent);
    }

    static void displayMessage(String tempMsg, Pokemon pokemon, Pokemon opponent) {
        //auto ajust line
        int lineNb = 0;
        if(tempMsg.length() >= maxLogLength){
            String[] cutMsg = tempMsg.split("\\W+");
            int msgLength = 0;
            for (String word : cutMsg) {
                msgLength = msgLength + word.length() + 1;
                if(msgLength>=maxLogLength){
                    //si on s apprette a depasser
                    System.out.print("\n" + word + " ");
                    msgLength = word.length() + 1;
                    lineNb++;
                } else{
                    System.out.print(word + " ");;
                }
            }
        } else{
            logp(tempMsg);
        }
        int backlineNeededNb = 3 - lineNb;
        for (int i = 0; i < backlineNeededNb; i++){
            logp("");
        }
        writeLine();
    }


    static String getStartMessage(Pokemon opponent){
        return opponent.getName() + " wants to fight !";
    }

    static String getDisplayAttacks(Pokemon pokemon){
        int topLineSpacesNb = maxLogLength - pokemon.getAtksList().get(0).getName().length() - pokemon.getAtksList().get(2).getName().length();
        int bottomLineSpacesNb = maxLogLength - pokemon.getAtksList().get(1).getName().length() - pokemon.getAtksList().get(3).getName().length();
        String str = "1:" + pokemon.getAtksList().get(0).getName() + writeSpace(topLineSpacesNb) + "3:" + pokemon.getAtksList().get(2).getName()
                + "\n2:" + pokemon.getAtksList().get(1).getName() + writeSpace(bottomLineSpacesNb) + pokemon.getAtksList().get(3).getName();
        return str;
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
        msg =  opponent.getName() + " wants to fight !";
    }

    static void ofhsjfhoq(){
        msg = "salut";
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
