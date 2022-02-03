package com.example.group4_decisionbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //XML ids for text and button
        text = findViewById(R.id.textView);
        btn1 = findViewById(R.id.btnchoice1);

        //String for the setting
        String setting =
                "Once upon a time, a demon lord was overruling humans. \n" +
                        "A man sick of this decided to fight the demon lord and end this";
        text.setText(setting);

    }

    public void goGameScreen(View v) {
        //Runs the code for the button to go to the next activity
        Intent gamescreen = new Intent(this, GameScreen.class);
        startActivity(gamescreen);
        }
    }

