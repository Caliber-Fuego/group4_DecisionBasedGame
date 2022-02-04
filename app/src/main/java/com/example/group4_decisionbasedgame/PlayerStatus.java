package com.example.group4_decisionbasedgame;


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
        this.heroHPoints = heroHPoints;
    }
    public void setHeroMinDamage(int heroMinDamage) {
        this.heroMinDamage = heroMinDamage;
    }

    public void setHeroMaxDamage(int heroMaxDamage) {
        this.heroMaxDamage = heroMaxDamage;
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

}
