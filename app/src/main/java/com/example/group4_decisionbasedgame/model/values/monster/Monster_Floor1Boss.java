package com.example.group4_decisionbasedgame.model.values.monster;

import android.widget.TextView;

import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;

import java.util.Random;

public class Monster_Floor1Boss extends MonsterStatus {


    Items items = new Items();
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();

    Random randomizer = new Random();

    private int Weakened = 0;

    private int curse = 0;
    private int burn = 0;

    boolean cursedstatus = false;
    boolean burnedstatus = false;

    public Monster_Floor1Boss(){
        monsterName = "Cursed Knight";
        monHPts = 650;
        monMinDmg = 30;
        monMaxDmg = 75;

    }
    public int getWeakened() {
        return Weakened;
    }

    public void setWeakened(int weakened) {
        Weakened = weakened;
    }

    public void Monster_TrueFloor1Boss(){
        setMonsterName("Vincent, the Knight of the Sun");
        setMonMinDmg(40);
        setMonMaxDmg(90);
    }

    public void bossDamage(int maxDamage, int minDamage, int armor, TextView text) {

        if(cursedstatus = false){
            int monsterDamage = (randomizer.nextInt(maxDamage - minDamage) + minDamage) - (armor*10);
            status.setHeroHPoints(status.getHeroHPoints() - monsterDamage);
            text.setText(""+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you \n " +
                    "You are cursed!");
            cursedstatus = true;
            curse = 3;
        }else if(cursedstatus=true){
            curse--;
            }if(this.curse==0){
                int monsterDamage = (randomizer.nextInt(maxDamage - minDamage) + minDamage) - (armor*10);
                status.setHeroHPoints(status.getHeroHPoints() - monsterDamage);
                text.setText("The "+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you");
                cursedstatus = false;
                }else{
                int cursedDamage = 2;
                int monsterDamage = (randomizer.nextInt(maxDamage - minDamage) + minDamage) - (armor*10);
                status.setHeroHPoints(status.getHeroHPoints() - (monsterDamage + cursedDamage));
                text.setText(""+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you \n " +
                        "The curse dealt "+cursedDamage+" damage to you!");
                }
    }

    public void burnMagic(int armor, TextView text){
        if(burnedstatus = false){
            int burnDamage = (randomizer.nextInt(30 - 25)+25)-(armor*10);
            status.setHeroHPoints(status.getHeroHPoints() - burnDamage);
            text.setText(""+monster.getMonsterName()+" casted Burn and dealt "+burnDamage+" damage to you \n " +
                    "You are burned!");
            burnedstatus = true;
            burn = 3;
        }else if(burnedstatus = true) {
            burn--;
                }if (this.burn == 0){
                int burnDamage = (randomizer.nextInt(30 - 25)+25)-(armor*10);
                status.setHeroHPoints(status.getHeroHPoints() - burnDamage);
                text.setText(""+monster.getMonsterName()+" casted Burn and dealt "+burnDamage+" damage to you");
                burnedstatus = false;
                }else {
                int burnDamage = (randomizer.nextInt(30 - 25)+25)-(armor*10);
                int burned = 2;
                status.setHeroHPoints(status.getHeroHPoints() - burnDamage);
                status.setHeroHPoints(status.getHeroHPoints() - (burnDamage + burned));
                text.setText(""+monster.getMonsterName()+" casted Burn and dealt "+burnDamage+" damage to you \n " +
                        "The burn dealt "+burned+" damage to you!");
                burn--;
                }
    }

    public void weakenedFormula (int monHPts, int monMinDmg, int monMaxDmg, int weakened){
        this.monHPts = monHPts - (weakened*5);
        this.monMinDmg = monMinDmg - (weakened*5);
        this.monMaxDmg = monMaxDmg - (weakened*5);
    }



}

