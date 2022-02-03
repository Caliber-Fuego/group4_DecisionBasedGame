package com.example.group4_decisionbasedgame;

import static com.example.group4_decisionbasedgame.R.id.stickButton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import com.example.group4_decisionbasedgame.weapon.HandWeapon;
import com.example.group4_decisionbasedgame.weapon.Weapon_LongSword;
import com.example.group4_decisionbasedgame.weapon.Weapon_Stick;

public class HeroStats extends AppCompatActivity implements View.OnClickListener{

    TextView txtHeroHp, txtWeapon, txtMinDmg, txtMaxDmg;
    Button backButton;
    ImageButton equipStick;

    //Lets the activity use the weapons
    HandWeapon hw = new HandWeapon();
    public HandWeapon currentWeapon;


    //Hero Stats
    int heroHPoints = 100;
    int heroMinDamage = (100);
    int heroMaxDamage = (150);

    //Monster Stats
    String monsName = "Monster";
    int monHPoints = 30;
    int monMinDamage = 10;
    int monMaxDamage = 15;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        txtHeroHp = findViewById(R.id.heroHP);
        txtWeapon = findViewById(R.id.weaponName);
        txtMinDmg = findViewById(R.id.minDmg);
        txtMaxDmg = findViewById(R.id.maxDmg);

        backButton = findViewById(R.id.backButton);
        equipStick = findViewById(stickButton);



    }
    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.stickButton:
                currentWeapon = new Weapon_Stick();
                break;
            case R.id.backButton:
                finish();
                break;
        }
        txtHeroHp.setText(String.valueOf(heroHPoints));
        txtMinDmg.setText(String.valueOf(heroMinDamage + currentWeapon.damage));
        txtMaxDmg.setText(String.valueOf(heroMaxDamage + currentWeapon.damage));


        equipStick.setOnClickListener(this);
        backButton.setOnClickListener(this);


        txtWeapon.setText(currentWeapon.name);
    }

}
