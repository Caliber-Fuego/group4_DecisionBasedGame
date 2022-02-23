package com.example.group4_decisionbasedgame.model.values.monster;

import com.example.group4_decisionbasedgame.model.MonsterStatus;

public class Monster_Slime extends MonsterStatus {

    public Monster_Slime(){
        //Sets the monster values in MonsterStatus
        monsterName = "Slime";
        monHPts = 400;
        monMinDmg = 15;
        monMaxDmg = 30;
    }
}
