package com.example.group4_decisionbasedgame.model;


import java.util.Random;

public class PlayerStatus {

    //Weapon values for name and the damage
    public static String name;
    public static int damage;

    //Hero Stats
    private static int heroHPoints = 100;
    private static int heroMinDamage = 100;
    private static int heroMaxDamage = 150;


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

    //Method for the damage calculation
    public int baseDamage(int heroMinDamage, int heroMaxDamage) {
        Random randomizer = new Random();
        return (randomizer.nextInt(heroMaxDamage - heroMinDamage) + heroMinDamage);
    }
    public int baseDamage(){
        return (0);
    }

}
