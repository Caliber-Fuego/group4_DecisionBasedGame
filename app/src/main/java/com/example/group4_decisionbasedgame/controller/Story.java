package com.example.group4_decisionbasedgame.controller;

import android.widget.TextView;

import com.example.group4_decisionbasedgame.model.values.monster.Monster_Floor1Boss;
import com.example.group4_decisionbasedgame.view.GameScreen;
import com.example.group4_decisionbasedgame.view.HeroStats;
import com.example.group4_decisionbasedgame.model.Items;
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
    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    //Lets Story call values from Player Status
    PlayerStatus status = new PlayerStatus();

    //Lets Story call values from Monster Status
    MonsterStatus monster = new MonsterStatus();
    Monster_Floor1Boss f1boss = new Monster_Floor1Boss();

    GameCalculations gc = new GameCalculations();

    private int floorCounter = 0;


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
            case "bossFight": bossFight(); break;
            case "bossAttack": bossAttack(); break;
            case "talkFight": talkFight(); break;
        }
    }

    //Rolls from 1 - 3 and then moves on to the assigned method
    public void roomRoll(TextView text){
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

        if(floorCounter < 5){
            floorCounter++;
        } else if (floorCounter == 5){
            text.setText("You feel a presence up ahead");
            nextPosition1 = "minibossRoom";
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
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

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
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

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

        roomRoll(gs.text);
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
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));


        roomRoll(gs.text);
    }
    public void itemRoom (){
        gc.itemRoll(gs.text, gs.itemqty1);

        roomRoll(gs.text);
    }

    public void minibossRoom (){
        monster = new Monster_Floor1Boss();
        gs.text.setText("a Floor master appears! \n" +
                        "A knight cursed by the Demon Lord, his presence feels familiar to you. \n" +
                        "You unlocked the TALK option!");

        gs.btn2.setText("Talk");

        nextPosition1 = "bossFight";
        nextPosition2 = "talkFight";
    }
    public void bossFight(){
        int playerDamage = gc.baseDamage(status.getHeroMinDamage(), status.getHeroMaxDamage(),0);
        gs.text.setText("You attacked the "+monster.getMonsterName()+" and gave " + playerDamage + " damage");

        monster.setMonHPts(monster.getMonHPts() - playerDamage);
        monster.getMonHPts();

        gs.btn1.setText(">");
        gs.btn2.setText(" ");

        if(monster.getMonHPts() >  0){
            nextPosition1 = "bossAttack";
            nextPosition2 = " ";
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "win";
            nextPosition2 = " ";
        }
    }

    public void talkFight(){
        f1boss.setWeakened(f1boss.getWeakened()+1);
        gs.text.setText("You tried to talk with the "+monster.getMonsterName()+".");

        f1boss.weakenedFormula(monster.getMonHPts(), monster.getMonMinDmg(), monster.getMonMaxDmg(), f1boss.getWeakened());

        if(monster.getMonHPts() >  0){
            nextPosition1 = "bossAttack";
            nextPosition2 = " ";
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "win";
            nextPosition2 = " ";
        }
    }
    public void bossAttack(){

        Random roll = new Random();
        int bossRoll = roll.nextInt(2);

        if (bossRoll==0){
            gc.bossDamage(monster.getMonMaxDmg(), monster.getMonMinDmg(), status.getArmor(), gs.text);
        }else if(bossRoll==1){
            gc.burnMagic(status.getArmor(), gs.text);
        }


        status.getHeroHPoints();
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        if (status.getHeroHPoints() > 0){
            nextPosition1 = "bossFight";
            nextPosition2 = " ";
        }
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }

    }



}