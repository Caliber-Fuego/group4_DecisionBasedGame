package com.example.group4_decisionbasedgame.model.values.monster;

import android.widget.TextView;

import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;

import java.util.Random;

public class Monster_Colonel extends MonsterStatus {
    Items items = new Items();
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();
    Random randomizer = new Random();

    //Debuff Damage
    private int cursedDamage = 10;

    //Debuff Count
    private int curse = 0;

    //Debuff Status
    boolean cursedstatus = false;

    public Monster_Colonel(){
        monsterName = "Demon Colonel";
        monHPts = 900;
        monMinDmg = 40;
        monMaxDmg = 60;
    }

    public int getCurse() {
        return curse;
    }
    public void setCurse(int curse) {
        this.curse = curse;
    }


    public void curseMagic (TextView text){
        if (cursedstatus=true){
            text.setText("The hero has already been cursed!");
        }else{
            text.setText("The "+monster.getMonsterName()+" has cursed you!");
            curse = 3;
            cursedstatus = true;
        }
    }

    public void cursedDamage (TextView text){
        if (curse > 0){
            status.setHeroHPoints(status.getHeroHPoints() - this.cursedDamage);
            text.setText("The "+monster.getMonsterName()+"'s curse dealt "+this.cursedDamage+" damage to you");
            curse--;
        }else if (curse==1){
            status.setHeroHPoints(status.getHeroHPoints() - this.cursedDamage);
            text.setText("The "+monster.getMonsterName()+"'s curse dealt "+this.cursedDamage+" damage to you");
            curse--;
            cursedstatus = false;
        }

    }
}
