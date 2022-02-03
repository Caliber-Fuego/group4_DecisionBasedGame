package com.example.group4_decisionbasedgame;

import com.example.group4_decisionbasedgame.weapon.Weapon_LongSword;
import com.example.group4_decisionbasedgame.weapon.Weapon_Stick;

import java.util.Random;

public class Story {


    GameScreen gs;
    String nextPosition1, nextPosition2;
    boolean longsword = false;

    HeroStats hs = new HeroStats();


    //Allows Story class to access buttons and textviews from GameScreen
    public Story(GameScreen gs) {

        this.gs = gs;
    }

    public void selectPosition(String position){
    //Corresponds buttons to cases

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
        }
    }
    public void startingPoint(){
            //sets text for the case "startingPoint"
        gs.text.setText("You are at the Demon Lord Castle Gate.\n" +
                        "what will you do?");
        hs.currentWeapon = new Weapon_Stick();

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
        longsword = true;

        gs.btn1.setText("Continue on");
        gs.btn2.setText("Go back outside");

        nextPosition1 = "monsterEncounter";
        nextPosition2 = "startingPoint";
        }
    public  void monsterEncounter() {
        gs.text.setText("A Monster attacks you! \n\n What do you do?");

        gs.btn1.setText("Fight");
        gs.btn2.setText("Run");

        nextPosition1 = "playerAttack";
        nextPosition2 = "getSword";
    }
    public  void playerAttack(){

        Random randomizer = new Random();
        int playerDamage = randomizer.nextInt((hs.heroMaxDamage - hs.heroMinDamage) + hs.heroMaxDamage);
        gs.text.setText("You attacked the monster and gave " + playerDamage + " damage");

        hs.monHPoints = hs.monHPoints - playerDamage;

        gs.btn1.setText(">");
        gs.btn2.setText(" ");

        if(hs.monHPoints>  0){
            nextPosition1 = "monsterAttack";
            nextPosition2 = " ";

        }
        else if(hs.monHPoints < 1){
            nextPosition1 = "win";
            nextPosition2 = " ";
        }

    }
    public void monsterAttack(){
        Random randomizer = new Random();
        int monsterDamage = randomizer.nextInt((hs.monMaxDamage - hs.monMinDamage) + hs.monMaxDamage);
        hs.heroHPoints = hs.heroHPoints - monsterDamage;
        gs.hptext.setText(String.valueOf(hs.heroHPoints));

        gs.btn1.setText(">");
        gs.btn2.setText(" ");

        if (hs.heroHPoints > 0){
            nextPosition1 = "playerAttack";
            nextPosition2 = " ";
        }
        else if (hs.heroHPoints < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }
    }
    public void win(){
        gs.text.setText("You beat the monster!");
    }
    public void lose (){
        gs.text.setText("You lost");
    }

}