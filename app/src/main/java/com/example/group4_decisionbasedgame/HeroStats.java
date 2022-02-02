package com.example.group4_decisionbasedgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HeroStats extends AppCompatActivity {

    HeroStats hs;

    //Hero
    int heroHPoints = 100;

    public HeroStats(GameScreen gs) {

        this.hs = hs;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        TextView txtHeroHp = findViewById(R.id.heroHP);

        txtHeroHp.setText(String.valueOf(heroHPoints));
        }



    public void onClick (View v){
        finish();
    }

    }
