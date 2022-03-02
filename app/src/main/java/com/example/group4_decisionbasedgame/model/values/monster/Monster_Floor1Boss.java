package com.example.group4_decisionbasedgame.model.values.monster;

import android.widget.TextView;

import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;

import java.util.Random;

public class Monster_Floor1Boss extends MonsterStatus {

    //Lets you use certain actions
    Items items = new Items();
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();
    Random randomizer = new Random();

    //Weakened Stat
    private int Weakened = 0;

    //Debuff Count

    private int curse = 0;
    private int curseDamage = 5;

    private int burn = 0;

    private int burnedDamage = 5;

    //Debuff Status
    private int cursed = 0;
    private int burned = 0;

    boolean cursedstatus = false;
    boolean burnedstatus = false;
    //Boss' Stats

    public Monster_Floor1Boss(){
        monsterName = "Cursed Knight";
        monHPts = 800;
        monMinDmg = 30;
        monMaxDmg = 75;
    }
    //Getters

    public int getWeakened() {
        return Weakened;
    }
    public int getCurse() {
        return curse;
    }
    public int getBurn() {
        return burn;
    }
    //Setters

    public void setWeakened(int weakened) {
        Weakened = weakened;
    }
    public void setCurse(int curse) {
        this.curse = curse;
    }
    public void setBurn(int burn) {
        this.burn = burn;
    }

    //Boss' Second Form
    public void Monster_TrueFloor1Boss(){
        setMonsterName("Vincent, the Knight of the Sun");
        setMonMinDmg(40);
        setMonMaxDmg(90);
    }


    //Boss' First Attack
    public void bossDamage(int maxDamage, int minDamage, int armor, TextView text) {
        if(cursed == 0){
            int monsterDamage = (randomizer.nextInt(maxDamage - minDamage) + minDamage) - (armor*10);
            status.setHeroHPoints(status.getHeroHPoints() - monsterDamage);
            text.setText(""+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you \n " +
                    "You are cursed!");
            cursed = 1;
            curse = 3;
        }else if(cursed > 0){
            int monsterDamage = (randomizer.nextInt(maxDamage - minDamage) + minDamage) - (armor*10);
            status.setHeroHPoints(status.getHeroHPoints() - monsterDamage);
            text.setText("The "+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you \n" +
                         "The Hero is already cursed!");
        }
    }

    public void cursedDamage(TextView text){
        if (curse > 0){
            status.setHeroHPoints(status.getHeroHPoints() - this.curseDamage);
            text.setText("The "+monster.getMonsterName()+"'s curse dealt "+this.curseDamage+" damage to you");
            curse--;
        }else if (curse==1){
            status.setHeroHPoints(status.getHeroHPoints() - this.curseDamage);
            text.setText("The "+monster.getMonsterName()+"'s curse dealt "+this.curseDamage+" damage to you");
            curse--;
            cursed = 0;
        }else if (curse==0){
            text.setText("The Hero wasn't cursed.");
        }
    }

    //Boss' Second Attack
    public void burnMagic(int armor, TextView text){
        if(burned == 0){
            int burnDamage = (randomizer.nextInt(30 - 25)+25)-(armor*10);
            status.setHeroHPoints(status.getHeroHPoints() - burnDamage);
            text.setText(""+monster.getMonsterName()+" casted Burn and dealt "+burnDamage+" damage to you \n " +
                    "You are burned!");
            burned = 1;
            burn = 3;
        }else if(burned > 1) {
            int burnDamage = (randomizer.nextInt(30 - 25)+25)-(armor*10);
            status.setHeroHPoints(status.getHeroHPoints() - burnDamage);
            text.setText(""+monster.getMonsterName()+" casted Burn and dealt "+burnDamage+" damage to you \n" +
                         "You are already burned!");
        }
    }

    public void burnedDamage(TextView text){
        if (burn > 0){
            status.setHeroHPoints(status.getHeroHPoints() - this.burnedDamage);
            text.setText("The "+monster.getMonsterName()+"'s burn dealt "+this.burnedDamage+" damage to you");
            burn--;
        }else if (burn==1){
            status.setHeroHPoints(status.getHeroHPoints() - this.burnedDamage);
            text.setText("The "+monster.getMonsterName()+"'s burn dealt "+this.burnedDamage+" damage to you");
            burn--;
            burned = 0;
        }
    }

    public void weakenedFormula (int monHPts, int monMinDmg, int monMaxDmg, int weakened){
        this.monHPts = monHPts - (weakened*5);
        this.monMinDmg = monMinDmg - (weakened*5);
        this.monMaxDmg = monMaxDmg - (weakened*5);
    }



}

