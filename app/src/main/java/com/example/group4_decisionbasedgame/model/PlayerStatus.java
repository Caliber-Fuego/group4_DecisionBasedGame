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


    //Adds weapon damage to Player's min and max damage
    public void addDamage(int damage, int heroMinDamage, int heroMaxDamage) {
        PlayerStatus.heroMinDamage = damage + heroMinDamage;
        PlayerStatus.heroMaxDamage = damage + heroMaxDamage;
    }

    //adds a percent of player HP
    public void healHP(int heroHPoints, int healamt) {
        //PlayerStatus.heroHPoints = Math.min(heroHPoints + (int) (heroHPoints * (healamt/100.0f)), 100);
        PlayerStatus.heroHPoints = Math.min(heroHPoints + healamt, 100);
    }

}


