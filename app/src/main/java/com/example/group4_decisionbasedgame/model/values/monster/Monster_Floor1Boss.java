package com.example.group4_decisionbasedgame.model.values.monster;

import com.example.group4_decisionbasedgame.model.MonsterStatus;

public class Monster_Floor1Boss extends MonsterStatus {


    private int Weakened = 0;

    public Monster_Floor1Boss(){
        monsterName = "Cursed Knight";
        monHPts = 1000;
        monMinDmg = 30;
        monMaxDmg = 75;

    }

    public int getWeakened() {
        return Weakened;
    }

    public void setWeakened(int weakened) {
        Weakened = weakened;
    }

    public void weakenedFormula (int monHPts, int monMinDmg, int monMaxDmg, int weakened){
        //(MonsterStat)-(x * 5)
        this.monHPts = monHPts - (weakened*5);
        this.monMinDmg = monMinDmg - (weakened*5);
        this.monMaxDmg = monMaxDmg - (weakened*5);
    }



}

