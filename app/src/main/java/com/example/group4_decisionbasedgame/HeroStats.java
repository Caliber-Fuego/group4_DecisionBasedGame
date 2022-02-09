package com.example.group4_decisionbasedgame;

import static com.example.group4_decisionbasedgame.R.id.stickButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.group4_decisionbasedgame.model.PlayerStatus;

public class HeroStats extends AppCompatActivity implements View.OnClickListener{

    TextView txtHeroHp, txtWeapon, txtMinDmg, txtMaxDmg;
    Button backButton;
    ImageButton equipStick;

    //Lets the activity call values from PlayerStatus
    PlayerStatus status = new PlayerStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        //XML IDs for texts and buttons
        txtHeroHp = findViewById(R.id.heroHP);
        txtWeapon = findViewById(R.id.weaponName);
        txtMinDmg = findViewById(R.id.minDmg);

        backButton = findViewById(R.id.backButton);
        equipStick = findViewById(stickButton);


        //Calls values from PlayerStatus
        txtHeroHp.setText(String.valueOf(status.getHeroHPoints()));
        txtMinDmg.setText(String.valueOf(status.getHeroMinDamage() +" - "+status.getHeroMaxDamage()));
        txtWeapon.setText(status.name);


        //Sets onclicklisteners for the buttons
        equipStick.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }

    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.backButton:
                finish();
                break;
        }

    }

}
