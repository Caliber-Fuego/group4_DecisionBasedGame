package com.example.group4_decisionbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    TextView text;
    Button btn1, btn2;

    Story story = new Story(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        text = (TextView)findViewById(R.id.storyText);
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


}