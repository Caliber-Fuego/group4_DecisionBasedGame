package com.example.group4_decisionbasedgame.controller;

import android.media.MediaPlayer;
import android.widget.Switch;
import android.widget.TextView;

import com.example.group4_decisionbasedgame.R;
import com.example.group4_decisionbasedgame.model.Dialogues;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;
import com.example.group4_decisionbasedgame.model.values.monster.Monster_Colonel;
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
    MediaPlayer player;
    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    //Lets Story call values from other classes
    PlayerStatus status = new PlayerStatus();
    MonsterStatus monster = new MonsterStatus();
    Monster_Floor1Boss f1boss = new Monster_Floor1Boss();
    Monster_Colonel colonel = new Monster_Colonel();
    GameCalculations gc = new GameCalculations();
    Dialogues dlg = new Dialogues();


    //Story counters
    private int memoryCounter = 0;
    private static int floorCounter = 0;
    private static int deathCounter = 0;
    private static int battleCounter= 0;

    //Dialogue Counters
    private static int dcounter = 0;
    private int ecounter = 0;
    private int fcounter = 0;
    private int gcounter = 0;
    private int hcounter = 0;
    private int icounter = 0;
    private int jcounter = 0;
    private int kcounter = 0;
    private int lcounter = 0;

    //Story booleans
    boolean dlog = false;
    private int shkey = 0;
    private int lvl1card = 0;
    private int btnnote = 0;
    private int puzzlepiece1 = 0;
    private int puzzlepiece2 = 0;
    private int puzzlesolved = 0;



    //Getters for story values

    public int getFloorCounter() {
        return floorCounter;
    }
    public int getDeathCounter() {
        return deathCounter;
    }
    public int getBattleCounter() {
        return battleCounter;
    }
    public int getDcounter() {
        return dcounter;
    }

    //Setters for Story Values
    public static void setFloorCounter(int floorCounter) {
        Story.floorCounter = floorCounter;
    }
    public static void setDeathCounter(int deathCounter) {
        Story.deathCounter = deathCounter;
    }
    public static void setBattleCounter(int battleCounter) {
        Story.battleCounter = battleCounter;
    }
    public void setDcounter(int dcounter) {
        this.dcounter = dcounter;
    }

    //Allows Story class to access buttons and textviews from GameScreen
    public Story(GameScreen gs){this.gs = gs;}
    public Story(HeroStats hs) {this.hs = hs;}


    public void selectPosition(String position){
    //Whenever the nextposition strings change into any one of these cases, it leads to the method.
    //Which then allows the player to choose a decision and leads to another method.

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
            case "memory2": memory2(); break;
            case "memory3": memory3(); break;
            case "memory4": memory4(); break;
            case "m2GeneralRoom": m2GeneralRoom(); break;
            case "m2roomChest": m2roomChest(); break;
            case "m2roomCloset": m2roomCloset(); break;
            case "m2roomTable": m2roomTable(); break;
            case "apothecary": apothecary(); break;
            case "strengthBrew": strengthBrew(); break;
            case "charismaBrew": charismaBrew(); break;
            case "healthBrew": healthBrew(); break;
            case "m2Door": m2Door(); break;
            case "m4suggest1": m4suggest1(); break;
            case "m4suggest2": m4suggest2(); break;
            case "wizardTalk": wizardTalk(); break;
            case "guardTalk": guardTalk(); break;
            case "guardConfront": guardConfront(); break;
            case "memory5": memory5(); break;
            case "m5elevator": m5elevator(); break;
            case "m5barracks": m5barracks(); break;
            case "m5btnroom": m5btnroom(); break;
            case "m5prison": m5prison(); break;
            case "m5secondfloor": m5secondfloor(); break;
            case "m5elevator2": m5elevator2(); break;
            case "m5colonelroom": m5colonelroom(); break;
            case "m5fileroom": m5fileroom(); break;
            case "cabinetinspect": cabinetinspect(); break;
            case "fileroomexplore": fileroomexplore(); break;
            case "m5btnred": m5btnred(); break;
            case "m5btnblue": m5btnblue(); break;
            case "m5library": m5library(); break;
            case "weaponread": weaponread(); break;
            case "stanceread": stanceread(); break;
            case "strategyread": strategyread(); break;
            case "m5memoryend": m5memoryend(); break;
            case "m5colonelfight": m5colonelfight(); break;
            case "colonelAttack": colonelAttack(); break;
            case "curseCheck": curseCheck(); break;
            case "vincentTurn": vincentTurn(); break;
            case "magusTurn": magusTurn(); break;
            case "leoTurn": leoTurn(); break;
            case "m5memoryend2": m5memoryend2(); break;
            case "bosscurse": bosscurse(); break;
            case "bossburn": bossburn(); break;
            case "nomemorytalk": nomemorytalk(); break;
            case "memorytalk": memorytalk(); break;
            case "killend": killend(); break;
            case "goodend": goodend(); break;

            //Dialogue Cases
            case "memoryd1":
                switch (dcounter){
                    case 0:gs.text.setText(dlg.M1_1);
                        dcounter++; break;
                    case 1:gs.text.setText(dlg.M1_2);
                        dcounter++; break;
                    case 2:gs.text.setText(dlg.M1_3);
                        dcounter++; break;
                    case 3:gs.text.setText(dlg.M1_4);
                        dcounter++;
                        memoryCounter++;
                        roomRoll(gs.text); break;
                }
                break;
            case "memoryd2":
                if (dcounter==0){
                    gs.text.setText(dlg.M2_1);
                    dcounter++;
                }else if (dcounter==1){
                    gs.text.setText(dlg.M2_2);
                    gs.image1.setImageResource(R.drawable.bg_strongholdoor);
                    setTexts("Open the door", "Go to a Room", "Go to Potion Lab", "Break down the Door");

                    nextPosition1 = " ";
                    nextPosition2 = "m2GeneralRoom";
                    nextPosition3 = "apothecary";
                    nextPosition4 = " ";

                    if (shkey == 1) {
                        nextPosition1 = "m2Door";
                    }
                    if (status.getSTR()>=15){
                        nextPosition4 = "m2Door";
                        }
                    }
                break;
            case "memoryd2_1":
                switch (dcounter){
                    case 0: gs.text.setText(dlg.M2_6);
                        gs.btn1.setText("Let's stop.");
                        dcounter++; break;
                    case 1: gs.text.setText(dlg.M2_7);
                        gs.image1.setImageResource(R.drawable.bg_room2);
                        gs.btn1.setText("I'll pay you more.");
                        dcounter++;break;
                    case 2: gs.text.setText(dlg.M2_8);
                        gs.image1.setImageResource(R.drawable.bg_room3);
                        gs.btn1.setText("Continue");
                        dcounter++; break;
                    case 3: gs.text.setText("The memory ends there");
                        memoryCounter++;
                        roomRoll(gs.text); break;

                } break;
            case "memoryd3":
                switch (dcounter){
                    case 0: gs.text.setText(dlg.M3_1);
                        dcounter++; break;
                    case 1: gs.text.setText(dlg.M3_2);
                        gs.image1.setImageResource(R.drawable.bg_ceremony1);
                        dcounter++; break;
                    case 2: gs.text.setText(dlg.M3_3);
                        gs.image1.setImageResource(R.drawable.bg_ceremony2);
                        dcounter++; break;
                    case 3: gs.text.setText(dlg.M3_4);
                        status.setSTR(status.getSTR()+10);
                        memoryCounter++;
                        roomRoll(gs.text); break;
                }break;
            case "memoryd4":
                if (dcounter==0){
                    gs.text.setText(dlg.M4_1);
                    dcounter++;
                }else if (dcounter==1){
                    gs.text.setText(dlg.M4_2);
                    dcounter++;
                }else if (dcounter==2){
                    gs.text.setText(dlg.M4_3);
                    gs.image1.setImageResource(R.drawable.bg_wartable1);
                    dcounter++;

                    setTexts("Suggest Attack", "Suggest Probe", "Talk to Wizard", "Talk to Guard");

                    nextPosition1 = "m4suggest1";
                    nextPosition2 = "m4suggest2";
                    nextPosition3 = "wizardTalk";
                    nextPosition4 = "guardTalk";
                }
                break;
            case "guardDialogue":
                if (dcounter==1){
                    gs.text.setText(dlg.M4_13);
                    dcounter++;
                    setTexts("Beat him up.", "Your appearance.", "", "");

                    nextPosition1 = "guardSTR";
                    nextPosition2 = "guardINT";
                    nextPosition3 = "";
                    nextPosition4 = "";
                }
                break;
            case "guardSTR":
                if (dcounter==2){
                    gs.image1.setImageResource(R.drawable.bg_guard2);
                    gs.text.setText(dlg.M4_14beat);
                    dcounter++;
                    setTexts("Tell me your base", "", "", "");

                    nextPosition1 = "guardSTR";
                    nextPosition2 = "";
                } else if (dcounter==3){
                    gs.image1.setImageResource(R.drawable.bg_guard);
                    gs.text.setText(dlg.M4_15);
                    dcounter++;
                    setTexts("Threaten him", "", "", "");

                    nextPosition1 = "guardSTR";
                    nextPosition2 = "";
                } else if (dcounter==4){
                    gs.image1.setImageResource(R.drawable.bg_guard2);
                    gs.text.setText(dlg.M4_16beat);
                    dcounter ++;
                    setTexts("Continue", "", "", "");

                    nextPosition1 = "guardSTR";
                    nextPosition2 = "";
                } else if (dcounter==5){
                    gs.image1.setImageResource(R.drawable.bg_guard2);
                    gs.text.setText(dlg.M4_17beat);
                    status.setSTR(status.getSTR()+5);
                    status.setINT(status.getINT()+2);
                    memoryCounter++;
                    roomRoll(gs.text);
                }
                break;
            case "guardINT":
                if (dcounter==2){
                    gs.image1.setImageResource(R.drawable.bg_guard3);
                    gs.text.setText(dlg.M4_14int);
                    dcounter++;
                    setTexts("Tell me your base", "", "", "");

                    nextPosition1 = "guardINT";
                    nextPosition2 = "";
                } else if (dcounter==3){
                    gs.image1.setImageResource(R.drawable.bg_guard);
                    gs.text.setText(dlg.M4_15);
                    dcounter++;
                    setTexts("You're lying", "", "", "");

                    nextPosition1 = "guardINT";
                    nextPosition2 = "";
                } else if (dcounter==4){
                    gs.image1.setImageResource(R.drawable.bg_guard3);
                    gs.text.setText(dlg.M4_16int);
                    dcounter ++;
                    setTexts("Okay", "", "", "");

                    nextPosition1 = "guardINT";
                    nextPosition2 = "";
                } else if (dcounter==5){
                    gs.image1.setImageResource(R.drawable.bg_guard);
                    gs.text.setText(dlg.M4_17int);
                    status.setSTR(status.getSTR()+2);
                    status.setINT(status.getINT()+5);
                    memoryCounter++;
                    roomRoll(gs.text);
                }
                break;
            case "memoryd5":
                if (dcounter==0){
                    gs.text.setText(dlg.M5_1);
                    dcounter++;
                } else if (dcounter==1){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);
                    gs.text.setText(dlg.M5_2);
                    dcounter++;
                } else if (dcounter==2){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);
                    gs.text.setText(dlg.M5_3);
                    dcounter++;
                } else if (dcounter==3){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);
                    gs.text.setText(dlg.M5_4);
                    dcounter++;
                } else if (dcounter==4){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);
                    gs.text.setText(dlg.M5_5);
                    dcounter++;
                } else if (dcounter==5){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);
                    gs.text.setText(dlg.M5_6);
                    dcounter++;
                } else if (dcounter==6){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);
                    gs.text.setText(dlg.M5_7);
                    dcounter++;
                } else if (dcounter==7){
                    gs.image1.setImageResource(R.drawable.bg_m5strongholdoor);
                    gs.text.setText(dlg.M5_8);

                    setTexts("Go to elevator", "Go to barracks", "Go to btn room", "Go to prison");

                    nextPosition1 = "m5elevator";
                    nextPosition2 = "m5barracks";
                    nextPosition3 = "m5btnroom";
                    nextPosition4 = "m5prison";
                }
                break;
            }
    }

    //Method for rolling from 1 - 3 and then moves on to the assigned method
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

    //General outline for Dialogue and Decision Methods
    public void startingPoint(){
        //sets text for the case "startingPoint" or any of the other cases
        gs.image1.setImageResource(R.drawable.bg_castlegate);

        //If the player has died once or more, then this message will show up instead of the other one.
        if(deathCounter > 0){
            gs.text.setText("You wake up infront of a castle Gate.\n" +
                    "You also remember dying before this. \n" +
                    "What will you do?");
        }else {
            gs.text.setText("You wake up infront of a castle Gate.\n" +
                    "You also don't remember anything that happened before then \n" +
                    "What will you do?");
        }

        //Default values
        setFloorCounter(0);
        status.setHeroHPoints(100);
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        //Sets texts for the buttons.
        setTexts("Open the Gate", "Examine the gate", "Look around", "Kill yourself.");

        //Sets the strings that directs the player to the next dialogue
        nextPosition1 = "oldMan";
        nextPosition2 = "castleGate";
        nextPosition3 = "plainFields";
        nextPosition4 = "gameOver";
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
        deathCounter++;
        this.getDeathCounter();

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

        setTexts("Continue On", "Go back outside", "","");

        nextPosition1 = "monsterEncounter";
        nextPosition2 = "startingPoint";
        }
    public  void monsterEncounter() {
        gs.battlebgm();
        monster = new Monster_Slime();
        gs.image1.setImageResource(R.drawable.monster_slime);
        gs.text.setText("A " + monster.getMonsterName() + " attacks you! \n\n What do you do?");

        setTexts("Fight", " ", " ", " ");

        nextPosition1 = "playerAttack";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }
    public  void playerAttack(){
        gs.slashsoundeffect();
        //Calculates Player Damage to the Monster
        int playerDamage = gc.baseDamage(status.getHeroMinDamage(), status.getHeroMaxDamage(),status.getSTR(), 0);
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
    gs.enemyattacksfx();
    //Calculates Monster Damage to the Player
        int monsterDamage = gc.baseDamage(monster.getMonMinDmg(),monster.getMonMaxDmg(), 0 , status.getArmor());
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
        gs.explorebgm();
        gs.text.setText("You beat the monster!");
        gs.image1.setImageResource(R.drawable.bg_cave);
        battleCounter++;

        gs.btn1.setText("Continue");
        gs.btn2.setText("");

        if (battleCounter==1){
            nextPosition1 = "memory1";
        }else if (battleCounter==2){
            nextPosition1 = "memory2";
        }else if (battleCounter==3){
            nextPosition1 = "memory3";
        }else if (battleCounter==4){
            nextPosition1 = "memory4";
        }else if (memoryCounter==4){
            nextPosition1 = "memory5";
        }
        else {
            roomRoll(gs.text);
        }

    }

    public void memory1(){
        gs.memorybgm();
        gs.text.setText("You remember a memory from the old times.");
        gs.image1.setImageResource(R.drawable.bg_war);
        setDcounter(0);
        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd1";
        nextPosition2 = " ";
        nextPosition3 = " ";
        nextPosition4 = " ";
    }

    public void memory2(){
        gs.memory2bgm();
        gs.text.setText("You remember a memory from the old times.");
        gs.image1.setImageResource(R.drawable.bg_strongholdoor);
        setDcounter(0);

        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd2";
    }

    public void memory3(){
        gs.memorybgm();
        gs.text.setText("You remember a memory from the old times.");
        gs.image1.setImageResource(R.drawable.bg_ceremony);
        setDcounter(0);

        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd3";
        nextPosition2 = " ";
        nextPosition3 = " ";
        nextPosition4 = " ";
    }

    public void memory4(){
        gs.memory4bgm();
        gs.text.setText("You remember a memory from the old times.");
        gs.image1.setImageResource(R.drawable.bg_wartable);
        setDcounter(0);

        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd4";
        nextPosition2 = " ";
        nextPosition3 = " ";
        nextPosition4 = " ";

    }

    public void memory5(){
        gs.memory5bgm();
        gs.text.setText("You remember a memory from the old times.");
        gs.image1.setImageResource(R.drawable.bg_m5strongholdoor);

        setDcounter(0);

        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd5";
        nextPosition2 = " ";
        nextPosition3 = " ";
        nextPosition4 = " ";
    }

    public void m5elevator(){
        switch (ecounter){
            case 0: gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);
                gs.text.setText(dlg.M5_9);
                ecounter++; break;
            case 1: gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);
                gs.text.setText(dlg.M5_10);
                ecounter++; break;
            case 2: gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);
                gs.text.setText(dlg.M5_11);
                ecounter++; break;
            case 3: gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);
                gs.text.setText(dlg.M5_12);
                ecounter++; break;
            case 4: gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);
                gs.text.setText(dlg.M5_13);
                ecounter++; break;
            case 5: gs.image1.setImageResource(R.drawable.bg_elevator);
                gs.text.setText(dlg.M5_14);
                ecounter++; break;
        }

        if (ecounter==6){
            gs.image1.setImageResource(R.drawable.bg_elevator);
            gs.text.setText(dlg.M5_14);
            setTexts("", "Go to barracks", "Go to btn room", "Go to prison");

            nextPosition1 = "";
            nextPosition2 = "m5barracks";
            nextPosition3 = "m5btnroom";
            nextPosition4 = "m5prison";

            if (lvl1card==1){
                setTexts("Go up", "Go to barracks", "Go to btn room", "Go to prison");
                nextPosition1 = "m5secondfloor";
            }
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "m5elevator";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void m5barracks(){
        switch (fcounter){
            case 0: gs.text.setText(dlg.M5_15);fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5barracks);break;
            case 1:gs.text.setText(dlg.M5_16);fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 2: gs.text.setText(dlg.M5_17);fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);break;
            case 3: gs.text.setText(dlg.M5_18); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 4: gs.text.setText(dlg.M5_19); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 5: gs.text.setText(dlg.M5_20); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorguard);break;
            case 6: gs.text.setText(dlg.M5_21); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 7: gs.text.setText(dlg.M5_22); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorguard);break;
            case 8: gs.text.setText(dlg.M5_23); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 9: gs.text.setText(dlg.M5_24); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorguard);break;
            case 10: gs.text.setText(dlg.M5_25); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 11: gs.text.setText(dlg.M5_26); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorguard);break;
            case 12: gs.text.setText(dlg.M5_27); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 13: gs.text.setText(dlg.M5_28); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 14: gs.text.setText(dlg.M5_29); fcounter++; lvl1card = 1;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);break;
            case 15: gs.text.setText(dlg.M5_30); fcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5barracks);break;
        }

        if (fcounter==16){
            gs.text.setText(dlg.M5_30);
            gs.image1.setImageResource(R.drawable.bg_m5barracks);
            setTexts("Go to elevator", "", "Go to btn room", "Go to prison");

            nextPosition1 = "m5elevator";
            nextPosition2 = "";
            nextPosition3 = "m5btnroom";
            nextPosition4 = "m5prison";
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "m5barracks";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void m5btnroom(){
        gs.image1.setImageResource(R.drawable.bg_m5buttonroom);
        if (btnnote==1){
            gs.text.setText("You find two buttons here, " +
                            "a red one and a blue one, which one will you push?");
        }else {
            gs.text.setText("There are so many buttons here, " +
                    "However you see no reason to push them.");
        }
        if (btnnote==1){
            setTexts("Push the red button", "Push the blue button", "", "Go Back");

            nextPosition1 = "m5btnred";
            nextPosition2 = "m5btnblue";
            nextPosition3 = "";
            nextPosition4 = "memoryd5";
        }else {
            setTexts("Go to elevator", "Go to barracks", "", "Go to prison");

            nextPosition1 = "m5elevator";
            nextPosition2 = "m5barracks";
            nextPosition3 = "";
            nextPosition4 = "m5prison";
        }
    }

    public void m5btnred(){
        gs.text.setText("You press the red button and it drops a triangular stone in front of you.");
        puzzlepiece2 = 1;

        setTexts("", "Push the blue button", "", "Go Back");

        nextPosition1 = "";
        nextPosition2 = "m5btnblue";
        nextPosition3 = "";
        nextPosition4 = "memoryd5";
    }

    public void m5btnblue(){
        gs.text.setText("You press the blue button and it drops a health potion!");

        items = new item_hpBottle();
        items.setQuantity(items.getQuantity()+1);
        gs.itemqty1.setText(String.valueOf(items.getQuantity()));

        setTexts("Push the red button", "", "", "Go Back");

        nextPosition1 = "m5btnred";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "memoryd5";

    }

    public void m5prison(){
        switch (gcounter){
            case 0: gs.text.setText(dlg.M5_31);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 1: gs.text.setText(dlg.M5_32);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5prisonroom);break;
            case 2: gs.text.setText(dlg.M5_33);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);break;
            case 3: gs.text.setText(dlg.M5_34);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 4: gs.text.setText(dlg.M5_35);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);break;
            case 5: gs.text.setText(dlg.M5_36);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 6: gs.text.setText(dlg.M5_37);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 7: gs.text.setText(dlg.M5_38);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 8: gs.text.setText(dlg.M5_39);gcounter++; puzzlepiece1 = 1;
                gs.image1.setImageResource(R.drawable.bg_m5prisonroom);break;
            case 9: gs.text.setText(dlg.M5_40);gcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5prisonroom);break;
        }

        if (gcounter==10){
            gs.text.setText(dlg.M5_40);
            puzzlepiece1 = 1;
            gs.image1.setImageResource(R.drawable.bg_m5prisonroom);
            setTexts("Go to elevator", "Go to barracks", "Go to btn room", "");

            nextPosition1 = "m5elevator";
            nextPosition2 = "m5barracks";
            nextPosition3 = "m5btnroom";
            nextPosition4 = "";
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "m5prison";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void m5secondfloor() {
        switch (hcounter){
            case 0: gs.text.setText(dlg.M5_41);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 1: gs.text.setText(dlg.M5_42);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);break;
            case 2: gs.text.setText(dlg.M5_43);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);break;
            case 3: gs.text.setText(dlg.M5_44);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoormag1);break;
            case 4: gs.text.setText(dlg.M5_45);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 5: gs.text.setText(dlg.M5_46);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);break;
            case 6: gs.text.setText(dlg.M5_47);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 7: gs.text.setText(dlg.M5_48);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);break;
            case 8: gs.text.setText(dlg.M5_49);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorleo1);break;
            case 9: gs.text.setText(dlg.M5_50);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoorvin1);break;
            case 10: gs.text.setText(dlg.M5_51);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoor);break;
            case 11: gs.text.setText(dlg.M5_52);hcounter++;
                gs.image1.setImageResource(R.drawable.bg_m5strongholdoor);break;
        }
        if (hcounter==12){
            gs.text.setText(dlg.M5_52);
            gs.image1.setImageResource(R.drawable.bg_m5strongholdoor);
            setTexts("Go to elevator", "Go to Colonel Room", "Go to File Room", "Go to Library");

            nextPosition1 = "m5elevator2";
            nextPosition2 = "m5colonelroom";
            nextPosition3 = "m5fileroom";
            nextPosition4 = "m5library";
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "m5secondfloor";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void m5elevator2(){
        gs.text.setText(dlg.M5_e53);
        gs.image1.setImageResource(R.drawable.bg_elevator);

        setTexts("Go Down", "Go to Colonel Room", "Go to File Room", "Go to Library");

        nextPosition1 = "m5elevator";
        nextPosition2 = "m5colonelroom";
        nextPosition3 = "m5fileroom";
        nextPosition4 = "m5library";
    }

    public void m5colonelroom(){
        if (puzzlepiece1==1 && puzzlepiece2==1){
            gs.text.setText(dlg.M5_57);
            puzzlesolved = 1;
        }else {
            gs.text.setText(dlg.M5_53);
        }

        if (puzzlesolved==1){
            setTexts("Go Inside", "", "", "");

            nextPosition1 = "m5memoryend";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }else {
            setTexts("Go to Elevator", "", "Go to File Room", "Go to Library");

            nextPosition1 = "m5elevator2";
            nextPosition2 = "";
            nextPosition3 = "m5fileroom";
            nextPosition4 = "m5library";
        }
    }

    public void m5library(){
        gs.text.setText(dlg.M5_58);
        gs.image1.setImageResource(R.drawable.bg_m5library);
        setTexts("Read about Weapons", "Read about Stances", "Read about Strategy", "Go back");

        nextPosition1 = "weaponread";
        nextPosition2 = "stanceread";
        nextPosition3 = "strategyread";
        nextPosition4 = "m5secondfloor";
    }

    public void weaponread(){
        if(status.getINT()>=6){
            gs.text.setText(dlg.M5_59);
            status.setSTR(status.getSTR()+5);
        }else {
            gs.text.setText(dlg.M5_59alt);
        }

        setTexts("", "Read about Stances", "Read about Strategy", "Go back");


        nextPosition1 = "";
        nextPosition2 = "stanceread";
        nextPosition3 = "strategyread";
        nextPosition4 = "m5secondfloor";
    }

    public void stanceread(){
        if(status.getINT()>=6){
            gs.text.setText(dlg.M5_60);
            status.setSTR(status.getSTR()+5);
        }else {
            gs.text.setText(dlg.M5_59alt);
        }
        setTexts("Read about Weapons", "", "Read about Strategy", "Go back");

        nextPosition1 = "weaponread";
        nextPosition2 = "";
        nextPosition3 = "strategyread";
        nextPosition4 = "m5secondfloor";
    }

    public void strategyread(){
        if(status.getINT()>=6){
            gs.text.setText(dlg.M5_61);
            status.setINT(status.getINT()+1);
            status.setCHR(status.getCHR()+1);
        }else {
            gs.text.setText(dlg.M5_59alt);
        }
        gs.text.setText(dlg.M5_61);
        setTexts("Read about Weapons", "Read about Stances", "", "Go back");


        nextPosition1 = "weaponread";
        nextPosition2 = "stanceread";
        nextPosition3 = "";
        nextPosition4 = "m5secondfloor";
    }


    public void m5fileroom(){
        gs.text.setText(dlg.M5_54);
        gs.image1.setImageResource(R.drawable.bg_m5fileroom);
        setTexts("Inspect Cabinets", "Explore Room", "Go Back", "");

        nextPosition1 = "cabinetinspect";
        nextPosition2 = "fileroomexplore";
        nextPosition3 = "m5secondfloor";
        nextPosition4 = "";
    }

    public void cabinetinspect(){
        gs.text.setText(dlg.M5_55);
        btnnote = 1;

        setTexts("", "Explore Room", "Go Back", "");

        nextPosition1 = "";
        nextPosition2 = "fileroomexplore";
        nextPosition3 = "m5secondfloor";
        nextPosition4 = "";

    }

    public void fileroomexplore(){
        gs.text.setText(dlg.M5_56);
        status.setINT(status.getINT()+1);

        setTexts("Inspect Cabinets", "", "Go Back", "");

        nextPosition1 = "cabinetinspect";
        nextPosition2 = "";
        nextPosition3 = "m5secondfloor";
        nextPosition4 = "";

    }

    public void m5memoryend() {
        switch (icounter) {
            case 0: gs.text.setText(dlg.M5_62);icounter++; gs.m5endbgm();
                gs.image1.setImageResource(R.drawable.bg_colonelroom);break;
            case 1: gs.text.setText(dlg.M5_63);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom1);break;
            case 2: gs.text.setText(dlg.M5_64);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomleo1);break;
            case 3: gs.text.setText(dlg.M5_65);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom1);break;
            case 4: gs.text.setText(dlg.M5_66);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1);break;
            case 5: gs.text.setText(dlg.M5_67);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom1);break;
            case 6: gs.text.setText(dlg.M5_68);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom2);break;
            case 7: gs.text.setText(dlg.M5_69);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomleo1);break;
            case 8: gs.text.setText(dlg.M5_70);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom1);break;
            case 9: gs.text.setText(dlg.M5_71);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom2);break;
            case 10: gs.text.setText(dlg.M5_72);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroommag1);break;
            case 11: gs.text.setText(dlg.M5_73);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom2);break;
            case 12: gs.text.setText(dlg.M5_74);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin2);break;
            case 13: gs.text.setText(dlg.M5_75);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom);break;
            case 14: gs.text.setText(dlg.M5_76);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom2);break;
            case 15: gs.text.setText(dlg.M5_77);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin2);break;
            case 16: gs.text.setText(dlg.M5_78);icounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom);break;
        }
        if (icounter==17){
            gs.text.setText(dlg.M5_78);
            gs.image1.setImageResource(R.drawable.bg_colonelroom);
            monster = new Monster_Colonel();
            gs.m5endfight();
            setTexts("Fight", "", "", "");

            nextPosition1 = "m5colonelfight";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "m5memoryend";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void m5colonelfight(){
        gs.slashsoundeffect();
        int playerDamage = gc.baseDamage(status.getHeroMinDamage(), status.getHeroMaxDamage(), status.getSTR() , 0);
        gs.text.setText("You attacked the "+monster.getMonsterName()+" and gave " + playerDamage + " damage");

        monster.setMonHPts(monster.getMonHPts() - playerDamage);
        monster.getMonHPts();

        setTexts(">", "", "", "");

        if(monster.getMonHPts() >  0){
            nextPosition1 = "vincentTurn";
            nextPosition2 = " ";
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "m5memoryend2";
            nextPosition2 = " ";
        }
    }

    public void vincentTurn(){
        gs.slashsoundeffect();
        gs.image1.setImageResource(R.drawable.bg_colonelroomvin);
        gc.vincentAttack(gs.text, status.getSTR());
        monster.getMonHPts();

        if(monster.getMonHPts() >  0){
            nextPosition1 = "magusTurn";
            nextPosition2 = " ";
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "m5memoryend2";
            nextPosition2 = " ";
        }
    }

    public void magusTurn(){
        gs.slashsoundeffect();
        gs.image1.setImageResource(R.drawable.bg_castlegatemage);
        gc.magusAttack(gs.text, gs.hptext, gs.healthbar, status.getINT());
        monster.getMonHPts();

        if(monster.getMonHPts() >  0){
            nextPosition1 = "leoTurn";
            nextPosition2 = " ";
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "m5memoryend2";
            nextPosition2 = " ";
        }
    }

    public void leoTurn(){
        gs.slashsoundeffect();
        gs.image1.setImageResource(R.drawable.bg_castlegateleo);
        gc.leoAttack(gs.text, status.getSTR());
        monster.getMonHPts();

        if(monster.getMonHPts() >  0){
            nextPosition1 = "colonelAttack";
            nextPosition2 = " ";
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "m5memoryend2";
            nextPosition2 = " ";
        }
    }

    public void colonelAttack(){
        gs.enemyattacksfx();
        gs.image1.setImageResource(R.drawable.bg_colonelroom1);
        Random roll = new Random();
        int bossRoll = roll.nextInt(2);
        if (bossRoll==0){
            int monsterDamage = gc.baseDamage(colonel.getMonMinDmg(), colonel.getMonMaxDmg(), 0, status.getArmor());
            gs.text.setText("The "+monster.getMonsterName()+" dealt "+monsterDamage+" damage to you");

            status.setHeroHPoints(status.getHeroHPoints() - monsterDamage);
            status.getHeroHPoints();
            gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
            gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        }else if(bossRoll==1){
            colonel.curseMagic(gs.text);
        }

         if (status.getHeroHPoints() > 0){
            setTexts("Fight", "", "", "");
            nextPosition1 = "m5colonelfight";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";

             if(colonel.getCurse() > 0) {
                 setTexts(">", "", "", "");
                 nextPosition1 = "curseCheck";
                 nextPosition2 = "";
                 nextPosition3 = "";
                 nextPosition4 = "";
             }
        }else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void curseCheck(){
        colonel.cursedDamage(gs.text);
        status.getHeroHPoints();
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        if (status.getHeroHPoints() > 0){
            nextPosition1 = "m5colonelfight";
            nextPosition2 = " ";
        }
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }
    }

    public void m5memoryend2() {
        switch (jcounter) {
            case 0: gs.text.setText(dlg.M5_79);jcounter++; gs.m5endbgm();
                gs.image1.setImageResource(R.drawable.bg_colonelroom2);break;
            case 1: gs.text.setText(dlg.M5_80);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin);break;
            case 2: gs.text.setText(dlg.M5_81);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin);break;
            case 3: gs.text.setText(dlg.M5_82);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom1);break;
            case 4: gs.text.setText(dlg.M5_83);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin);break;
            case 5: gs.text.setText(dlg.M5_84);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 6: gs.text.setText(dlg.M5_85);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_castlegateleo);break;
            case 7: gs.text.setText(dlg.M5_86);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 8: gs.text.setText(dlg.M5_87);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroommag1);break;
            case 9: gs.text.setText(dlg.M5_88);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 10: gs.text.setText(dlg.M5_89);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin);break;
            case 11: gs.text.setText(dlg.M5_90);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 12: gs.text.setText(dlg.M5_91);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 13: gs.text.setText(dlg.M5_92);jcounter++; gs.vincent();
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin);break;
            case 14: gs.text.setText(dlg.M5_93);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin);break;
            case 15: gs.text.setText(dlg.M5_94);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 16: gs.text.setText(dlg.M5_95);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 17: gs.text.setText(dlg.M5_96);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroommag2);break;
            case 18: gs.text.setText(dlg.M5_97);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 19: gs.text.setText(dlg.M5_98);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomleo1);break;
            case 20: gs.text.setText(dlg.M5_99);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 21: gs.text.setText(dlg.M5_100);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 22: gs.text.setText(dlg.M5_101);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 23: gs.text.setText(dlg.M5_102);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroommag2);break;
            case 24: gs.text.setText(dlg.M5_103);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom3);break;
            case 25: gs.text.setText(dlg.M5_104);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 26: gs.text.setText(dlg.M5_105);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 27: gs.text.setText(dlg.M5_106);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 28: gs.text.setText(dlg.M5_107);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 29: gs.text.setText(dlg.M5_108);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 30: gs.text.setText(dlg.M5_109);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 31: gs.text.setText(dlg.M5_110);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 32: gs.text.setText(dlg.M5_111);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 33: gs.text.setText(dlg.M5_112);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 34: gs.text.setText(dlg.M5_113);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 35: gs.text.setText(dlg.M5_114);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroomvin1shine);break;
            case 36: gs.text.setText(dlg.M5_115);jcounter++; status.setArmor(status.getArmor()+1);
                gs.image1.setImageResource(R.drawable.bg_colonelroom);break;
            case 37: gs.text.setText(dlg.M5_116);jcounter++;
                gs.image1.setImageResource(R.drawable.bg_colonelroom);break;
        }
        if (jcounter==38){
            gs.text.setText(dlg.M5_116);
            gs.image1.setImageResource(R.drawable.bg_colonelroom);
            setTexts("Continue", "", "", "");

            memoryCounter++;
            roomRoll(gs.text);
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "m5memoryend2";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void m4suggest1(){
        if (status.getSTR()>=30){
            gs.text.setText(dlg.M4_4);
            status.setCHR(status.getCHR()+5);
        }else {
            gs.text.setText (dlg.M4_5);
            status.setCHR(status.getCHR()+1);
        }

        setTexts("", "", "Talk to Wizard", "Talk to Guard");
        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "wizardTalk";
        nextPosition4 = "guardTalk";
    }

    public void m4suggest2(){
        if (status.getINT()>=10){
            gs.text.setText(dlg.M4_6);
            status.setCHR(status.getCHR()+5);
        }else {
            gs.text.setText (dlg.M4_7);
            status.setCHR(status.getCHR()+1);
        }

        setTexts("", "", "Talk to Wizard", "Talk to Guard");
        nextPosition1 = "";
        nextPosition2 = "";
        nextPosition3 = "wizardTalk";
        nextPosition4 = "guardTalk";
    }

    public void wizardTalk(){
        gs.image1.setImageResource(R.drawable.bg_wartable2);
        if (dcounter==3){
            gs.text.setText(dlg.M4_8);
            dcounter++;
        } else if (dcounter==4) {
            gs.text.setText(dlg.M4_9);
            status.setINT(status.getINT()+1);
            status.setSTR(status.getSTR()+1);
            dcounter++;
        } else if (dcounter==5) {
            gs.text.setText("The old man is stroking his chin.");
        }

        if (dcounter==5){
            setTexts("Suggest Attack", "Suggest Probe", " ", "Talk to Guard");

            nextPosition1 = "m4suggest1";
            nextPosition2 = "m4suggest2";
            nextPosition3 = "";
            nextPosition4 = "guardTalk";
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "wizardTalk";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void guardTalk(){
        gs.image1.setImageResource(R.drawable.bg_guard);
        setDcounter(0);
        if (dcounter==0){
            gs.text.setText(dlg.M4_10);
            dcounter++;
        }else if (dcounter==1){
            gs.text.setText(dlg.M4_11);
        }
        if (dcounter==1){
            setTexts("", "", "Come with me", "");

            nextPosition1 = "";
            nextPosition2 = "";
            nextPosition3 = "guardConfront";
            nextPosition4 = "";
        }else {
            setTexts("Continue", "", " ", " ");

            nextPosition1 = "guardTalk";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
        }
    }

    public void guardConfront(){
        gs.image1.setImageResource(R.drawable.bg_guard1);
        setDcounter(1);
        gs.text.setText(dlg.M4_12);

        setTexts("I don't recognize you.", "", "", "");

        nextPosition1 = "guardDialogue";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }


    public void m2Door(){
        gs.text.setText(dlg.M2_5);
        gs.image1.setImageResource(R.drawable.bg_room1);
        setDcounter(0);

        setTexts("Continue", "", "", "");

        nextPosition1 = "memoryd2_1";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
    }


    public void apothecary(){
        gs.text.setText(dlg.M2_4);
        gs.image1.setImageResource(R.drawable.bg_apothecary);

        setTexts("Make strength potion",
                 "Make beauty potion",
                 "Make health potion",
                 "Go back");

        nextPosition1 = "strengthBrew";
        nextPosition2 = "charismaBrew";
        nextPosition3 = "healthBrew";
        nextPosition4 = "memoryd2";
    }
    public void strengthBrew(){
        if (status.getINT()>=2){
            gs.text.setText("You made a strength potion! \n" +
                    "You felt a bit stronger.");
            status.setSTR(status.getSTR()+5);
        }else {
            gs.text.setText("You weren't smart enough");
        }

        setTexts(" ",
                "Make beauty potion",
                "Make health potion",
                "Go back");

        nextPosition1 = " ";
        nextPosition2 = "charismaBrew";
        nextPosition3 = "healthBrew";
        nextPosition4 = "memoryd2";
    }

    public void charismaBrew(){
        if (status.getINT()>=3){
            gs.text.setText("You made a beauty potion! \n" +
                    "You felt a bit beautiful");
            status.setCHR(status.getCHR()+1);
        }else {
            gs.text.setText("You weren't smart enough");
        }

        setTexts("Make strength potion",
                "",
                "Make health potion",
                "Go back");

        nextPosition1 = "strengthBrew";
        nextPosition2 = "";
        nextPosition3 = "healthBrew";
        nextPosition4 = "memoryd2";
    }

    public void healthBrew(){
        if (status.getINT()>=2){
            gs.text.setText("You made a bottle with red substance in it!");
            items = new item_hpBottle();
            items.setQuantity(items.getQuantity()+1);
            gs.itemqty1.setText(String.valueOf(items.getQuantity()));
        }else{
            gs.text.setText("You weren't smart enough");
        }

        setTexts("Make strength potion",
                "Make beauty potion",
                "",
                "Go back");

        nextPosition1 = "strengthBrew";
        nextPosition2 = "charismaBrew";
        nextPosition3 = "";
        nextPosition4 = "memoryd2";
    }

    public void m2GeneralRoom(){
        gs.text.setText(dlg.M2_3);
        gs.image1.setImageResource(R.drawable.bg_generalroom);
        setTexts("Open the chest", "Open the closet", "Look under table", "Go back");

        nextPosition1 = "m2roomChest";
        nextPosition2 = "m2roomCloset";
        nextPosition3 = "m2roomTable";
        nextPosition4 = "memoryd2";
    }

    public void m2roomChest(){
        if (status.getSTR()>=10){
            gs.text.setText("You successfully opened the Chest and found " +
                            "a key inside it.");
            shkey = 1;
        }else{
            gs.text.setText("You were not strong enough to open the chest.");
        }
        setTexts("","Open the closet", "Look under table", "Go back");

        nextPosition1 = "";
        nextPosition2 = "m2roomCloset";
        nextPosition3 = "m2roomTable";
        nextPosition4 = "memoryd2";
    }

    public void m2roomCloset(){
        gs.text.setText("You find an astonishingly good clothes!");
        status.setCHR(status.getCHR()+1);


        setTexts("Open the chest","", "Look under table", "Go back");

        nextPosition1 = "m2roomChest";
        nextPosition2 = "";
        nextPosition3 = "m2roomTable";
        nextPosition4 = "memoryd2";
    }

    public void m2roomTable(){
        gs.text.setText("You found a book about potion making. \n" +
                "You felt a bit smarter.");
        status.setINT(status.getINT()+1);
        setTexts("Open the chest", "Open the closet", "", "Go back");

        nextPosition1 = "m2roomChest";
        nextPosition2 = "m2roomCloset";
        nextPosition3 = "";
        nextPosition4 = "memoryd2";
    }

    public void lose (){
        gs.explorebgm();
        gs.text.setText("You lost");
        deathCounter++;

        gs.btn1.setText("Start Over");
        gs.btn2.setText(" ");

        //Resets the game
        nextPosition1 = "startingPoint";
        nextPosition2 = "";
    }

    public void healingRoom (){
        gs.explorebgm();
        gs.text.setText("You are in a space where you are safe from monster attack \n\n" +
                        "You decide to take a rest");
        gs.image1.setImageResource(R.drawable.bg_cave);

        //Adds 40% of the Player HP to Player's HP
        status.healHP(status.getHeroHPoints(), 40);
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        roomRoll(gs.text);
    }
    public void itemRoom (){
        gs.explorebgm();
        gs.image1.setImageResource(R.drawable.bg_treasure);
        gc.itemRoll(gs.text, gs.itemqty1);

        roomRoll(gs.text);
    }

    public void minibossRoom (){
        monster = new Monster_Floor1Boss();
        gs.m5endfight();
        gs.image1.setImageResource(R.drawable.monster_floor1boss);
        f1boss.setWeakened(0);
        kcounter = 0;
        gs.text.setText("a Floor master appears! \n" +
                        "A knight cursed by the Demon Lord, his presence feels familiar to you. \n" +
                        "You unlocked the TALK option!");

        gs.btn2.setText("Talk");

        nextPosition1 = "bossFight";
        nextPosition2 = "talkFight";
    }
    public void bossFight(){
        gs.slashsoundeffect();
        int playerDamage = gc.baseDamage(status.getHeroMinDamage(), status.getHeroMaxDamage(), status.getSTR(), 0);
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
            nextPosition1 = "killend";
            nextPosition2 = " ";

            if(f1boss.getWeakened()>=8){
                nextPosition1 = "goodend";
            }
        }
    }

    public void talkFight(){
        f1boss.setWeakened(f1boss.getWeakened()+1);
        gs.text.setText("You tried to talk with the "+monster.getMonsterName()+".");

        setTexts(">", "", "", "");

        f1boss.weakenedFormula(monster.getMonHPts(), monster.getMonMinDmg(), monster.getMonMaxDmg(), f1boss.getWeakened());
        if(monster.getMonHPts() >  0){
            nextPosition1 = "bossAttack";
            nextPosition2 = " ";

            if(f1boss.getWeakened() == 4) {
                gs.text.setText("He remembered the times before his death. \n" +
                        "The times, he spent with you as a friend. \n" +
                        "Just a little more now.");
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);
                f1boss.Monster_TrueFloor1Boss();

                if (memoryCounter == 5) {
                    nextPosition1 = "memorytalk";
                    nextPosition2 = " ";
                } else if (memoryCounter < 5) {
                    nextPosition1 = "nomemorytalk";
                    nextPosition2 = " ";
                }
            }
        }
        else if(monster.getMonHPts() < 1){
            nextPosition1 = "win";
            nextPosition2 = " ";
        }

    }
    public void nomemorytalk(){
        switch(kcounter){
            case 0: gs.text.setText(dlg.T_1);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 1: gs.text.setText(dlg.T_2);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 2: gs.text.setText(dlg.T_8);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
        }
        if (kcounter==3){
            gs.text.setText(dlg.T_8);
            gs.image1.setImageResource(R.drawable.monster_truefloor1boss);
            setTexts("Continue", "", "", "");
                nextPosition1 = "bossFight";
                nextPosition2 = " ";
        }else {
            setTexts("Continue", "", "", "");
            nextPosition1 = "nomemorytalk";
            nextPosition2 = " ";
        }
    }
    public void memorytalk(){
        switch(kcounter){
            case 0: gs.text.setText(dlg.T_1);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 1: gs.text.setText(dlg.T_3);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 2: gs.text.setText(dlg.T_4);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 3: gs.text.setText(dlg.T_5);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 4: gs.text.setText(dlg.T_6);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 5: gs.text.setText(dlg.T_7);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
            case 6: gs.text.setText(dlg.T_8);kcounter++;
                gs.image1.setImageResource(R.drawable.monster_truefloor1boss);break;
        }
        if (kcounter==7){
            gs.text.setText(dlg.T_8);
            gs.image1.setImageResource(R.drawable.monster_truefloor1boss);
            setTexts("Continue", "", "", "");
            nextPosition1 = "bossFight";
            nextPosition2 = " ";
        }else {
            setTexts("Continue", "", "", "");
            nextPosition1 = "memorytalk";
            nextPosition2 = " ";
        }
    }
    public void bossAttack(){
        gs.enemyattacksfx();
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

            if (f1boss.getCurse() > 0){
                setTexts(">", "", "", "");
                nextPosition1 = "bosscurse";
                nextPosition2 = "";
            }

            if (f1boss.getBurn() > 0){
                setTexts(">", "", "", "");
                nextPosition1 = "bosscurse";
                nextPosition2 = "";
            }

        }
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }
    }

    public void bosscurse(){
        f1boss.cursedDamage(gs.text);
        status.getHeroHPoints();
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        if (status.getHeroHPoints() > 0){
            setTexts("Fight", "Talk", "","");
            nextPosition1 = "bossFight";
            nextPosition2 = "talkFight";
                if (f1boss.getBurn() > 0){
                    setTexts(">", "", "", "");
                    nextPosition1 = "bossburn";
                    nextPosition2 = "";
                }
        }
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }
    }

    public void bossburn(){
        f1boss.burnedDamage(gs.text);
        status.getHeroHPoints();
        gs.hptext.setText(String.valueOf(status.getHeroHPoints()));
        gs.healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));

        if (status.getHeroHPoints() > 0){
            setTexts("Fight", "Talk", "","");
            nextPosition1 = "bossFight";
            nextPosition2 = "talkFight";
        }
        else if (status.getHeroHPoints() < 1){
            nextPosition1 = "lose";
            nextPosition2 = " ";
        }
    }

    public void killend(){
        switch(lcounter){
            case 0: gs.text.setText(dlg.E_1);lcounter++; gs.memorybgm();
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 1: gs.text.setText(dlg.E_2);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 2: gs.text.setText(dlg.E_3);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 3: gs.text.setText(dlg.E_4);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 4: gs.text.setText(dlg.E_5);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
          }
        if (lcounter==5){
            gs.text.setText(dlg.E_5);
            gs.image1.setImageResource(R.drawable.bg_cave);
            setTexts("", "", "", "");
            nextPosition1 = "";
            nextPosition2 = " ";
        }else {
            setTexts("Continue", "", "", "");
            nextPosition1 = "killend";
            nextPosition2 = " ";
        }
    }

    public void goodend(){
        switch(lcounter){
            case 0: gs.text.setText(dlg.G_1);lcounter++; gs.memorybgm();
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 1: gs.text.setText(dlg.G_2);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 2: gs.text.setText(dlg.G_3);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
            case 3: gs.text.setText(dlg.E_5);lcounter++;
                gs.image1.setImageResource(R.drawable.bg_cave);break;
    }
        if (lcounter==4){
            gs.text.setText(dlg.E_5);
            gs.image1.setImageResource(R.drawable.bg_cave);
            setTexts("", "", "", "");
            nextPosition1 = "";
            nextPosition2 = " ";
        }else {
            setTexts("Continue", "", "", "");
            nextPosition1 = "goodend";
            nextPosition2 = " ";
        }
    }
}