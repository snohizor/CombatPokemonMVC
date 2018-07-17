package model;


import controller.GameController;

import java.util.ArrayList;

public class Pokemon {



    private static ArrayList<Attack> atksList = new ArrayList<Attack>();

    public static ArrayList addAtkToList(Attack atk1, Attack atk2, Attack atk3, Attack atk4, ArrayList list){
        list.clear();
        list.add(atk1);
        list.add(atk2);
        list.add(atk3);
        list.add(atk4);
        return list;
    }

    public static Pokemon pkm1 = new Pokemon("Bulbizarre", 10,45,45, addAtkToList(Attack.tackle, Attack.roar, Attack.empty, Attack.empty, atksList), 49, 49, 65, 65, 45);
    public static Pokemon pkm2 = new Pokemon("Pikachu",    10,35,35, addAtkToList(Attack.tackle, Attack.roar, Attack.empty, Attack.empty, atksList),  55, 50, 50, 45, 90);

    private String name;
    private int lvl;
    private int hpMax;
    private int hp;
    private ArrayList<Attack> attackList;
    private int atk;
    private int def;
    private int sat;
    private int sde;
    private int spe;

    public Pokemon(String name, int lvl, int hpMax, int hp, ArrayList attackList, int atk, int def, int sat, int sde, int spe) {
        this.name = name;
        this.lvl = lvl;
        this.hpMax = hpMax;
        this.hp = hp;
        this.attackList = attackList == null ? new ArrayList<>() : attackList.size() > 4 ? new ArrayList<>() : attackList;
        this.atk = atk;
        this.def = def;
        this.sat = sat;
        this.sde = sde;
        this.spe = spe;
    }


    public void use(Attack attack, Pokemon opponent){
        double hpToRemove = ((((this.getLvl() * 0.4 + 2) * this.getAtk() * attack.getPower())/(opponent.getDef() * 50)) + 2);
        int result = (int) hpToRemove;
        opponent.setHp(opponent.getHp() - result);
        GameController.msg = "What is " + this.getName() + " gonna do ?";
    }


    public boolean attackSuccess(Integer indexOfAttack){
        return this.attackList.get(indexOfAttack).getAccuracy() > (int)(Math.random() * (100-0));
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public ArrayList<Attack> getAtksList() {
        return atksList;
    }

    public static void setAtksList(ArrayList<Attack> atksList) {
        Pokemon.atksList = atksList;
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