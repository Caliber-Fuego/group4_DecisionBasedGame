package com.example.group4_decisionbasedgame.controller;

import com.example.group4_decisionbasedgame.view.GameScreen;
import com.example.group4_decisionbasedgame.view.HeroStats;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;
import com.example.group4_decisionbasedgame.model.values.monster.Monster_Slime;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.weapon.Weapon_Barehand;
import com.example.group4_decisionbasedgame.model.values.weapon.Weapon_LongSword;

import java.util.Random;

public class Story {
    GameScreen gs;
    HeroStats hs;
    Items items;
    public String nextPosition1;
    public String nextPosition2;

    //Lets Story call values from Player Status
    PlayerStatus status = new PlayerStatus();

    //Lets Story call values from Monster Status
    MonsterStatus monster = new MonsterStatus();

    GameCalculations gc = new GameCalculations();

    int floorCounter = 0;


    //Allows Story class to access buttons and textviews from GameScreen
    public Story(GameScreen gs){this.gs = gs;}



    public void selectPosition(String position){
    //Allows the cases to be accessible by the buttons

        switch(position){
            //cases for Story strings
            case "startingPoint": startingPoint(); break;
            case "gameOver": gameOver(); break;
            case "oldMan": oldMan(); break;
            case "getSword": getSword(); break;
            case "monsterEncounter": monsterEncounter(); break;
            case "playerAttack": playerAttack(); break;
            case "monsterAttack": monsterAttack(); break;
            case "win": win(); break;
            case "lose": lose(); break;
            case "healingRoom": healingRoom(); break;
            case "itemRoom": itemRoom(); break;
            case "minibossRoom": minibossRoom(); break;
        }
    }
    public void defaultSetup(){
        status = new Weapon_Barehand();
    }

    public void startingPoint(){
            //sets text for the case "startingPoint"
        gs.text.setText("You are at the Demon Lord Castle Gate.\n" +
                        "what will you do?");
        status.setHeroHPoints(100);
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));

        gs.btn1.setText("Open the Gate");
        gs.btn2.setText("Go back and sleep");

        nextPosition1 = "oldMan";
        nextPosition2 = "gameOver";
            //Directs the buttons to the next case
    }

    public void gameOver(){
        gs.text.setText("You decide to give up on the quest and sleep.");

        gs.btn1.setText("Start Over");
        gs.btn2.setText("");

        nextPosition1 = "startingPoint";
        nextPosition2 = "";

    }
    public void oldMan(){
        gs.text.setText("You encounter an old man wearing a robe.\n" +
                        "'It's dangerous to go alone, take this.'\n \n" +
                        "He hands you over a sword, do you accept?");

        gs.btn1.setText("Take the Sword");
        gs.btn2.setText("Go back outside");

        nextPosition1 = "getSword";
        nextPosition2 = "startingPoint";
    }
    public void getSword(){
        gs.text.setText("Good luck young man on your quest");
        status = new Weapon_LongSword();
        gs.wpntxt.setText(status.name);
        status.addDamage(status.damage, status.getHeroMinDamage(), status.getHeroMaxDamage());

        gs.btn1.setText("Continue on");
        gs.btn2.setText("Go back outside");

        nextPosition1 = "monsterEncounter";
        nextPosition2 = "startingPoint";
        }
    public  void monsterEncounter() {
        monster = new Monster_Slime();
        gs.text.setText("A " + monster.getMonsterName() + " attacks you! \n\n What do you do?");


        gs.btn1.setText("Fight");
        gs.btn2.setText("Run");

        nextPosition1 = "playerAttack";
        nextPosition2 = "getSword";
    }
    public  void playerAttack(){

        //Calculates Player Damage to the Monster
        int playerDamage = gc.baseDamage(status.getHeroMinDamage(), status.getHeroMaxDamage(),0);
        gs.text.setText("You attacked the monster and gave " + playerDamage + " damage");

        monster.setMonHPts(monster.getMonHPts() - playerDamage);
        monster.getMonHPts();

        gs.btn1.setText(">");
        gs.btn2.setText(" ");

        //Checks if Monster HP is 0 or not, if not then moves to monster's turn
        if(monster.getMonHPts() >  0){
            nextPosition1 = "monsterAttack";
            nextPosition2 = " ";
        }
        //If Monster HP is 0, moves to the victory screen
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "win";
            nextPosition2 = " ";
        }

    }
    public void monsterAttack(){

    //Calculates Monster Damage to the Player
        int monsterDamage = gc.baseDamage(monster.getMonMinDmg(),monster.getMonMaxDmg(),status.getArmor());
        gs.text.setText("The "+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you");

        status.setHeroHPoints(status.getHeroHPoints() - monsterDamage);
        status.getHeroHPoints();
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));

        gs.btn1.setText(">");
        gs.btn2.setText(" ");

        //Checks if Player HP is 0 or not, if not then moves to player's turn
        if (status.getHeroHPoints() > 0){
            nextPosition1 = "playerAttack";
            nextPosition2 = " ";
        }
        //If Player HP is 0, moves to the defeat screen
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }
    }

    public void win(){
        gs.text.setText("You beat the monster!");

        gs.btn1.setText("Continue");
        gs.btn2.setText("");

        //Rolls from 1 - 3 and then moves on to the assigned method
        Random roll = new Random();
        int diceRoll = roll.nextInt(3);

        if (diceRoll==0){
            nextPosition1 = "monsterEncounter";
            nextPosition2 = "";
        } else if (diceRoll==1){
            nextPosition1 = "healingRoom";
            nextPosition2 = "";
        } else if (diceRoll==2){
            nextPosition1 = "itemRoom";
            nextPosition2 = "";
        }

        //Checks if Floor number is equal to five or not, if not adds +1 to the counter
        if(floorCounter<5){
            floorCounter++;
        }
        //If floor counter is equal to five, move on to the floor boss
        else if (floorCounter==5){
            gs.text.setText("You feel a presence up ahead");
            nextPosition1 = "minibossRoom";
        }

    }

    public void lose (){
        gs.text.setText("You lost");

        gs.btn1.setText("Start Over");
        gs.btn2.setText(" ");

        //Resets the game
        nextPosition1 = "startingPoint";
        nextPosition2 = "";

    }
    public void healingRoom (){
        gs.text.setText("You are in a space where you are safe from monster attack \n\n" +
                        "You decide to take a rest");

        //Adds 40% of the Player HP to Player's HP
        status.healHP(status.getHeroHPoints(), 40);
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));

        Random roll = new Random();
        int diceRoll = roll.nextInt(3);

        if (diceRoll==0){
            nextPosition1 = "monsterEncounter";
            nextPosition2 = "";
        } else if (diceRoll==1){
            nextPosition1 = "healingRoom";
            nextPosition2 = "";
        } else if (diceRoll==2){
            nextPosition1 = "itemRoom";
            nextPosition2 = "";
        }

        if(floorCounter<5){
            floorCounter++;
        } else if (floorCounter==5){
            gs.text.setText("You feel a presence up ahead");
            nextPosition1 = "minibossRoom";
        }


    }
    public void itemRoom (){
        Random roll = new Random();

        //Rolls from 0 - 2 and then sets elements into the assigned number
        int itemRoll = roll.nextInt(3);
        if (itemRoll==0){
            //Gives the player an hpBottle
            gs.text.setText("You found a treasure!");
            items = new item_hpBottle();
            items.setQuantity(items.getQuantity()+1);
            gs.itemqty1.setText(String.valueOf(items.getQuantity()));
        } else if (itemRoll==1){
            gs.text.setText("You found a treasure!");
            items = new item_hpBottle();
            items.setQuantity(items.getQuantity()+1);
            gs.itemqty1.setText(String.valueOf(items.getQuantity()));
        } else if (itemRoll==2){
            //Gives the player an armor
            gs.text.setText("You found an ancient armor!");
            status.setArmor(status.getArmor()+1);
        }


        int diceRoll = roll.nextInt(3);

        if (diceRoll==0){
            nextPosition1 = "monsterEncounter";
            nextPosition2 = "";
        } else if (diceRoll==1){
            nextPosition1 = "healingRoom";
            nextPosition2 = "";
        } else if (diceRoll==2){
            nextPosition1 = "itemRoom";
            nextPosition2 = "";
        }

        if(floorCounter<5){
            floorCounter++;
        } else if (floorCounter==5){
            gs.text.setText("You feel a presence up ahead");
            nextPosition1 = "minibossRoom";
        }
    }

    public void minibossRoom (){
        gs.text.setText("a Floor master appears!");

    }
}