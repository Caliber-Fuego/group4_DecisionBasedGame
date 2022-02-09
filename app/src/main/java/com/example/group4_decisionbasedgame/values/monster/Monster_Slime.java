package com.example.group4_decisionbasedgame.values.monster;

import com.example.group4_decisionbasedgame.model.MonsterStatus;

public class Monster_Slime extends MonsterStatus {

    public Monster_Slime(){
        //Sets the monster values in MonsterStatus
        monsterName = "Slime";
        monHPts = 300;
        monMinDmg = 15;
        monMaxDmg = 30;
    }
}
