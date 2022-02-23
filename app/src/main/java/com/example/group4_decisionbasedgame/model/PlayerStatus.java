package com.example.group4_decisionbasedgame.model;


import java.util.Random;

public class PlayerStatus {

    //Weapon values for name and the damage
    public static String name;
    public static int damage;

    //Hero Stats
    private static int heroHPoints = 100;
    private static int maxheroHPoints = 100;
    private static int heroMinDamage = 100;
    private static int heroMaxDamage = 150;
    private static int armor = 0;

    private static int STR = 0;
    private static int INT = 0;
    private static int CHR = 0;





    //Setters for int values
    public void setHeroHPoints(int heroHPoints) {
        PlayerStatus.heroHPoints = heroHPoints;
    }

    public void setHeroMinDamage(int heroMinDamage) {
        PlayerStatus.heroMinDamage = heroMinDamage;
    }
    public void setHeroMaxDamage(int heroMaxDamage) {
        PlayerStatus.heroMaxDamage = heroMaxDamage;
    }

    public void setMaxheroHPoints(int maxheroHPoints) {
        PlayerStatus.maxheroHPoints = maxheroHPoints;
    }
    public static void setArmor(int armor) {
        PlayerStatus.armor = armor;
    }

    public static void setSTR(int STR) {
        PlayerStatus.STR = STR;
    }

    public static void setINT(int INT) {
        PlayerStatus.INT = INT;
    }

    public static void setCHR(int CHR) {
        PlayerStatus.CHR = CHR;
    }

    //Getters for int values
    public int getHeroHPoints() {
        return heroHPoints;
    }
    public int getHeroMinDamage() {
        return heroMinDamage;
    }

    public int getHeroMaxDamage() {
        return heroMaxDamage;
    }

    public int getMaxheroHPoints() {
        return maxheroHPoints;
    }

    public static int getArmor() {
        return armor;
    }

    public static int getSTR() {
        return STR;
    }

    public static int getINT() {
        return INT;
    }

    public static int getCHR() {
        return CHR;
    }

    //Adds weapon damage to Player's min and max damage
    public void addDamage(int damage, int heroMinDamage, int heroMaxDamage) {
        PlayerStatus.heroMinDamage = damage + heroMinDamage;
        PlayerStatus.heroMaxDamage = damage + heroMaxDamage;
        return;
    }

    //adds a percent of player HP
    public void healHP(int heroHPoints, int healamt) {
        //PlayerStatus.heroHPoints = Math.min(heroHPoints + (int) (heroHPoints * (healamt/100.0f)), 100);
        PlayerStatus.heroHPoints = Math.min(heroHPoints + healamt, 100);
    }
}


