package com.example.group4_decisionbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.group4_decisionbasedgame.weapon.Weapon_Barehand;

public class GameScreen extends AppCompatActivity{

    TextView text, hptext, wpntxt;
    Button btn1, btn2, statsbtn;

    //Allows GameScreen class to call strings from Story class
    Story story = new Story(this);

    //Allows GameScreen class to call variables from HeroStats class
    HeroStats hs = new HeroStats();

    //Allows GameScreen to call values from PlayerStatus
    PlayerStatus status = new PlayerStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        //XML ids for texts and buttons
        text = (TextView)findViewById(R.id.storyText);
        hptext = (TextView)findViewById(R.id.healthDisplay);
        wpntxt = (TextView)findViewById(R.id.weapondisplayName);


        btn1 = (Button) findViewById(R.id.btnchoice01);
        btn2 = (Button) findViewById(R.id.btnchoice02);

        //The starting point of the game
        story.startingPoint();
        status = new Weapon_Barehand();

        //Displays the health points of the player
        hptext.setText(String.valueOf(status.getHeroHPoints()));
        wpntxt.setText(status.name);
    }

    public void btn1 (View view){
            //Runs the code to move on to the case placed in the button
        story.selectPosition(story.nextPosition1);

    }
    public void btn2 (View view){
            //Runs the code to move on to the case placed in the button
        story.selectPosition(story.nextPosition2);

    }

    public void viewHeroStats (View v) {
            //Runs the code for the button to move to the HeroStats class
        Intent openHeroStats = new Intent(this, HeroStats.class);
        startActivity(openHeroStats);

    }
}