package com.example.group4_decisionbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    TextView text, hptext;
    Button btn1, btn2;

    Story story = new Story(this);
    HeroStats heroStats = new HeroStats(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        text = (TextView)findViewById(R.id.storyText);
        hptext = (TextView)findViewById(R.id.healthDisplay);

        hptext.setText(String.valueOf(heroStats.heroHPoints));

        btn1 = (Button) findViewById(R.id.btnchoice01);
        btn2 = (Button) findViewById(R.id.btnchoice02);

        story.startingPoint();


    }

    public void btn1 (View view){
        story.selectPosition(story.nextPosition1);

    }
    public void btn2 (View view){
        story.selectPosition(story.nextPosition2);

    }

    public void viewHeroStats (View v){

        Intent herostats = new Intent(this, HeroStats.class);
        startActivity(herostats);
    }




}