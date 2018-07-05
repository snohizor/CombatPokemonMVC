package model;

import java.util.ArrayList;

public class Attack {

    public static Attack tackle = new Attack("Tackle", 10, 100);
    public static Attack roar =   new Attack("Roar",    0, 100);

    private String name;
    private int power;
    private int accuracy;

    public Attack(String name, int power, int accuracy) {
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
    }

    public Object addAttackToList(ArrayList list){
        return list.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

}
