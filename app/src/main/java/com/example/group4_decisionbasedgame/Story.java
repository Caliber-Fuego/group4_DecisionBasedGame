package com.example.group4_decisionbasedgame;

public class Story {


    GameScreen gs;
    String nextPosition1, nextPosition2;

    public Story(GameScreen gs) {

        this.gs = gs;
    }
    public void selectPosition(String position){

        switch(position){
            case "startingPoint": startingPoint(); break;
            case "gameOver": gameOver(); break;
        }
    }
    public void startingPoint(){

        gs.text.setText("You are at the Demon Lord Castle Gate.\n " +
                        "what will you do?");

        gs.btn1.setText("Open the Gate");
        gs.btn2.setText("Go back and sleep");

        nextPosition1 = "lootchest";
        nextPosition2 = "gameOver";
    }

    public void gameOver(){
        gs.text.setText("You decide to give up on the quest and sleep.");

        gs.btn1.setText("Start Over");
        gs.btn2.setText("");

        nextPosition1 = "startingPoint";
        nextPosition2 = "";

    }
}