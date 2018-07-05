package model;

import controller.GameController;

import java.util.ArrayList;
import java.util.Arrays;

import static controller.GameController.logp;

public class Pokemon {



    private static ArrayList<Attack> atksList = new ArrayList<Attack>();

    public static ArrayList addAtkToList(Attack atk1, Attack atk2, ArrayList list){
        list.clear();
        list.add(atk1);
        list.add(atk2);
        return list;
    }

    public static Pokemon pkm1 = new Pokemon("Bulbizarre", 45, addAtkToList(Attack.tackle, Attack.roar, atksList), 49, 49, 65, 65, 45);
    public static Pokemon pkm2 = new Pokemon("Pikachu",    35, addAtkToList(Attack.tackle, Attack.roar, atksList),  55, 50, 50, 90, 45);

    private String name;
    private int Hp;
    private ArrayList<Attack> attackList;
    private int atk;
    private int def;
    private int sat;
    private int sde;
    private int spe;

    public Pokemon(String name, int hp, ArrayList attackList, int atk, int def, int sat, int sde, int spe) {
        this.name = name;
        Hp = hp;
        this.attackList = attackList == null ? new ArrayList<>() : attackList.size() > 4 ? new ArrayList<>() : attackList;
        this.atk = atk;
        this.def = def;
        this.sat = sat;
        this.sde = sde;
        this.spe = spe;
    }

    public void attack(Integer indexOfAttack, Pokemon opponent) {
        System.out.println(this.attackList.get(1).getName());
        Attack attack = this.attackList.get(indexOfAttack);
        logp(this.getName() + " uses " + attack.getName() + " !");
        if(this.attackSuccess(indexOfAttack)){
            opponent.setHp(opponent.getHp() - attack.getPower());
            logp(opponent.getName() + " has now " + opponent.getHp() + " hp.");
        } else{
            logp("yo this shitass monster missed...");
        }
        int value = attack.getPower() * this.getAtk();
        double HPToRemove = value * GameController.factor;// TODO: 04/07/2018
        opponent.setHp((int) (opponent.getHp() - HPToRemove));
    }

    public boolean attackSuccess(Integer indexOfAttack){
        return this.attackList.get(indexOfAttack).getAccuracy() > (int)(Math.random() * (100-0));
    }

    public void displayStats(){
        logp("-------");
        logp(this.name);
        logp("hp : " + this.Hp);
        logp("atk: " + this.atk);
        logp("def: " + this.def);
        logp("sat: " + this.sat);
        logp("sde: " + this.sde);
        logp("spe: " + this.spe);
        logp("-------");
    }

    public void displayAttacks(){

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public ArrayList getAttackList() {
        ArrayList<Attack> list = new ArrayList<>();
        Attack atk1 = Attack.tackle;
        list.add(atk1);
        Attack atk2 = Attack.roar;
        list.add(atk2);
        return list;
    }

    public void setAttackList(ArrayList attackList) {
        this.attackList = attackList;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSat() {
        return sat;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getSde() {
        return sde;
    }

    public void setSde(int sde) {
        this.sde = sde;
    }

    public int getSpe() {
        return spe;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }
}