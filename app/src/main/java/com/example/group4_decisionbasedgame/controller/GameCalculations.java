package com.example.group4_decisionbasedgame.controller;

import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;
import com.example.group4_decisionbasedgame.controller.Story;
import com.example.group4_decisionbasedgame.model.Dialogues;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;
import com.example.group4_decisionbasedgame.view.GameScreen;

import org.w3c.dom.Text;

public class GameCalculations {

    //Lets the class use data from other classes
    Items items = new Items();
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();
    Dialogues dlg = new Dialogues();

    Random randomizer = new Random();
    Random roll = new Random();

    //Method for the damage calculation
    public int baseDamage(int minDamage, int maxDamage, int str, int armor) {
        return (randomizer.nextInt((maxDamage + str ) - (minDamage + str)) + (minDamage+str)) - (armor*10);
    }




    //Method for Item Randomization
    public void itemRoll(TextView text, TextView itemqty1){
        Random roll = new Random();

        //Rolls from 0 - 2 and then sets elements into the assigned number
        int itemRoll = roll.nextInt(3);
        if (itemRoll==0){
            //Gives the player an hpBottle
            text.setText("You found a treasure!");
            items = new item_hpBottle();
            items.setQuantity(items.getQuantity()+1);
            itemqty1.setText(String.valueOf(items.getQuantity()));
        } else if (itemRoll==1){
            text.setText("You found a treasure!");
            items = new item_hpBottle();
            items.setQuantity(items.getQuantity()+1);
            itemqty1.setText(String.valueOf(items.getQuantity()));
        } else if (itemRoll==2){
            //Gives the player an armor
            text.setText("You found an ancient armor!");
            status.setArmor(status.getArmor()+1);
        }
    }

    public void vincentAttack (TextView text, int str){
        int vincentMinDmg = 40;
        int vincentMaxDmg = 90;

        int npcDamage = (randomizer.nextInt((vincentMaxDmg + str) - (vincentMinDmg + str)) + (vincentMinDmg + str));
        monster.setMonHPts(monster.getMonHPts() - npcDamage);
        text.setText(("Vincent dealt "+npcDamage+" damage to "+monster.getMonsterName()));
    }

    public void magusAttack (TextView text, TextView hptext, ProgressBar healthbar, int INT){
        int magusMinDmg = 50;
        int magusMaxDmg = 100;

        Random roll = new Random();

        int turnRoll = roll.nextInt(2);
        if (turnRoll==0){
            int npcDamage = (randomizer.nextInt((magusMaxDmg + INT) - (magusMinDmg + INT)) + (magusMinDmg + INT));
            monster.setMonHPts(monster.getMonHPts() - npcDamage);
            text.setText("The Mage dealt "+npcDamage+" damage to "+monster.getMonsterName());
        }else if (turnRoll==1){
            text.setText("The Mage heals the hero!");
            status.healHP(status.getHeroHPoints(), 40);
            hptext.setText(String.valueOf(status.getHeroHPoints()));
            healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));
        }
    }

    public void leoAttack (TextView text, int str){
        int leoMinDmg = 30;
        int leoMaxDmg = 70;

        int npcDamage = (randomizer.nextInt((leoMaxDmg + str) - (leoMinDmg + str)) + (leoMinDmg + str));
        monster.setMonHPts(monster.getMonHPts() - npcDamage);
        text.setText(("Leo dealt "+npcDamage+" damage to "+monster.getMonsterName()));
    }





    public int baseDamage() {
        return (0);
    }
    public int monsterDamage(){
        return (0);
    }

}
