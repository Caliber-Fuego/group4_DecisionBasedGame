package com.example.group4_decisionbasedgame.controller;

import java.util.Random;

public class GameCalculations {

    Random randomizer = new Random();
    Random roll = new Random();

    //Method for the damage calculation
    public int baseDamage(int minDamage, int maxDamage, int armor) {
        return (randomizer.nextInt(maxDamage - minDamage) + minDamage) - (armor*10);
    }

    public int baseDamage() {
        return (0);
    }
    public int monsterDamage(){
        return (0);
    }

}
