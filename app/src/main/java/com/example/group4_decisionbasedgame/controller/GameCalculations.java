package com.example.group4_decisionbasedgame.controller;

import android.widget.TextView;

import java.util.Random;
import com.example.group4_decisionbasedgame.controller.Story;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;
import com.example.group4_decisionbasedgame.view.GameScreen;

public class GameCalculations {

    //Lets the class use data from other classes
    Items items = new Items();
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();
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





    public int baseDamage() {
        return (0);
    }
    public int monsterDamage(){
        return (0);
    }

}
