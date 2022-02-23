package com.example.group4_decisionbasedgame.controller;

import android.widget.TextView;

import com.example.group4_decisionbasedgame.R;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;
import com.example.group4_decisionbasedgame.model.values.monster.Monster_Floor1Boss;
import com.example.group4_decisionbasedgame.model.values.monster.Monster_Soldier;
import com.example.group4_decisionbasedgame.view.GameScreen;
import com.example.group4_decisionbasedgame.view.HeroStats;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.values.monster.Monster_Slime;
import com.example.group4_decisionbasedgame.model.MonsterStatus;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.weapon.Weapon_LongSword;

import java.util.Random;

public class Story {
    GameScreen gs;
    HeroStats hs;
    Items items;
    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    //Lets Story call values from other classes
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();
    Monster_Floor1Boss f1boss = new Monster_Floor1Boss();
    GameCalculations gc = new GameCalculations();


    //States the counters for each one
    private int floorCounter = 0;
    private int deathCounter = 0;
    private int battleCounter= 0;
    private int dcounter = 0;

    public void setDcounter(int dcounter) {
        this.dcounter = dcounter;
    }




    //Allows Story class to access buttons and textviews from GameScreen
    public Story(GameScreen gs){this.gs = gs;}



    public void selectPosition(String position){
    //Allows the cases to be accessible by the buttons

        switch(position){
            //cases for Story strings
            case "startingPoint": startingPoint(); break;
            case "castleGate": castleGate(); break;
            case "plainFields": plainFields(); break;
            case "gameOver": gameOver(); break;
            case "oldMan": oldMan(); break;
            case "healOldMan": healOldMan(); break;
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
            case "memory1": memory1(); break;

            //Dialogue Case
            case "memoryd1":
                if (dcounter==0) {
                    gs.text.setText("You look around and see thousands of soldiers, fighting each other." +
                                    " You realize that you are wearing the same uniform as one of the soldiers." +
                                    " It seems like you are in a war.");
                    dcounter++;
                }else if (dcounter==1){
                    gs.text.setText("You have no clue which kingdom these uniforms belong to, nor" +
                                    " do you know why they are fighting.");
                    dcounter++;
                }else if (dcounter==2){
                    gs.text.setText("What you do know however, is that you must fight and survive");
                    dcounter++;
                }else if (dcounter==3) {
                    gs.text.setText("The memory ends there.");
                    nextPosition1 = "win";
                }
                break;
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

    //Method for setting Texts
    public void setTexts(String text1, String text2, String text3, String text4) {
        gs.btn1.setText(text1);
        gs.btn2.setText(text2);
        gs.btn3.setText(text3);
        gs.btn4.setText(text4);
    }



    public void startingPoint(){
            //sets text for the case "startingPoint"
        gs.image1.setImageResource(R.drawable.bg_castlegate);
        if(deathCounter > 0){
            gs.text.setText("You wake up infront of a castle Gate.\n" +
                    "You also remember dying before this. \n" +
                    "What will you do?");
        }else {
            gs.text.setText("You wake up infront of a castle Gate.\n" +
                    "You also don't remember anything that happened before then \n" +
                    "What will you do?");
        }

        status.setHeroHPoints(100);
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        setTexts("Open the Gate", "Examine the gate", "Look around", "Kill yourself.");

        nextPosition1 = "oldMan";
        nextPosition2 = "castleGate";
        nextPosition3 = "plainFields";
        nextPosition4 = "gameOver";
            //Directs the buttons to the next method
    }

    public void castleGate(){
        gs.image1.setImageResource(R.drawable.bg_castlegate);
        gs.text.setText("You examine the gate and find strange patterns on it \n" +
                        "Otherwise, you find nothing else.\n" +
                        "You felt a bit smarter.");
        status.setINT(status.getINT()+1);

        setTexts("Open the Gate", "", "", "Kill yourself.");

        nextPosition1 = "oldMan";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "gameOver";

    }

    public void plainFields(){
        gs.image1.setImageResource(R.drawable.bg_plains);

        gs.text.setText("You look around and see a desolate wasteland full of nothing. \n" +
                        "You do however, find a bottle full of red substance.");
        items = new item_hpBottle();
        items.setQuantity(items.getQuantity()+1);
        gs.itemqty1.setText(String.valueOf(items.getQuantity()));

        setTexts("Open the Gate", "", "", "Kill yourself.");

        nextPosition1 = "oldMan";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "gameOver";

    }

    public void gameOver(){
        gs.text.setText("You died in the middle of the quest.");
        deathCounter ++;

        setTexts("Start Over", "", "", "");

        nextPosition1 = "startingPoint";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    public void oldMan(){
        gs.image1.setImageResource(R.drawable.bg_oldman);
        gs.text.setText("You encounter an old man lying on the ground\n" +
                        "He also has a sword right beside him\n" +
                        "What will you do?");
        items = new item_hpBottle();

        if(items.getQuantity()>0){
            gs.btn2.setText("Use bottle on him.");
        }else{
            gs.btn2.setText("");
        }
        gs.btn1.setText("Take the Sword");
        gs.btn3.setText("");
        gs.btn4.setText("Go back outside");


        nextPosition1 = "getSword";
        if(items.getQuantity()>0){
            nextPosition2 = "healOldMan";
        }else{
            nextPosition2 = "";
        }
        nextPosition3 = "";
        nextPosition4 = "startingPoint";
    }
    public void healOldMan(){
        gs.text.setText("'Ahh, I nearly died there! Be careful, there are monsters up ahead.' \n" +
                        "'Here, have my sword.. I'll also bless you while i'm at it.' \n" +
                        "You felt a bit more powerful.");
        status.setSTR(status.getSTR()+5);

        setTexts("Take the Sword", "", "", "Go back");

        nextPosition1 = "getSword";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "startingPoint";
    }

    public void getSword(){
        gs.text.setText("You continued on and find a dark cave.");
        gs.image1.setImageResource(R.drawable.bg_cave);
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
        gs.image1.setImageResource(R.drawable.monster_slime);
        gs.text.setText("A " + monster.getMonsterName() + " attacks you! \n\n What do you do?");


        gs.btn1.setText("Fight");
        gs.btn2.setText("");

        nextPosition1 = "playerAttack";
        nextPosition2 = "";
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

        gs.btn1.setText("Fight");
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
        gs.image1.setImageResource(R.drawable.bg_cave);
        battleCounter++;

        gs.btn1.setText("Continue");
        gs.btn2.setText("");

        if (battleCounter==1){
            nextPosition1 = "memory1";
        }else {
            roomRoll(gs.text);
        }

    }

    public void memory1(){
        gs.text.setText("You remember a memory from the old times.");
        gs.image1.setImageResource(R.drawable.bg_war);
        setDcounter(0);
        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd1";

    }

    public void lose (){
        gs.text.setText("You lost");
        deathCounter++;

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
        if(f1boss.getWeakened() == 4){
            gs.text.setText("He remembered the times before his death. \n" +
                    "The times, he spent with you as a friend. \n" +
                    "Just a little more now.");
            f1boss.Monster_TrueFloor1Boss();
        }

        gs.btn1.setText(">");
        gs.btn2.setText("");

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
            f1boss.bossDamage(monster.getMonMaxDmg(), monster.getMonMinDmg(), status.getArmor(), gs.text);
        }else if(bossRoll==1){
            f1boss.burnMagic(status.getArmor(), gs.text);
        }

        status.getHeroHPoints();
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        gs.btn1.setText("Fight");
        gs.btn2.setText("Talk");

        if (status.getHeroHPoints() > 0){
            nextPosition1 = "bossFight";
            nextPosition2 = "talkFight";
        }
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }

    }
}