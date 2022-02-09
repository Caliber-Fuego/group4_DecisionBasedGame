package com.example.group4_decisionbasedgame.model;

import java.util.Random;

public class MonsterStatus {

    //Strings and Values of the Monster
    protected static String monsterName;

    protected int monHPts;
    protected int monMinDmg;
    protected int monMaxDmg;


    //Getters
    public static String getMonsterName() {
        return monsterName;
    }
    public int getMonHPts() {
        return monHPts;
    }
    public int getMonMinDmg() {
        return monMinDmg;
    }
    public int getMonMaxDmg() {
        return monMaxDmg;
    }


    //Setters
    public void setMonMinDmg(int monMinDmg) {
        this.monMinDmg = monMinDmg;
    }
    public static void setMonsterName(String monsterName) {
        MonsterStatus.monsterName = monsterName;
    }
    public void setMonHPts(int monHPts) {
        this.monHPts = monHPts;
    }
    public void setMonMaxDmg(int monMaxDmg) {
        this.monMaxDmg = monMaxDmg;
    }

    //Monster Damage Calculations
    public int monsterDamage (int monMinDamage, int monMaxDamage){
        Random randomizer = new Random();
        return (randomizer.nextInt(monMaxDamage - monMinDamage) + monMinDamage);

    }
    public int monsterDamage(){
        return (0);
    }


}
