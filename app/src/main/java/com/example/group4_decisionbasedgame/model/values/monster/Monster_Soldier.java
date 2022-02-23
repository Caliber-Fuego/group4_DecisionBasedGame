package com.example.group4_decisionbasedgame.model.values.monster;

import com.example.group4_decisionbasedgame.model.MonsterStatus;

public class Monster_Soldier extends MonsterStatus {

    public Monster_Soldier(){
        //Sets the monster values in MonsterStatus
        monsterName = "Soldier";
        monHPts = 200;
        monMinDmg = 10;
        monMaxDmg = 20;
    }
}
