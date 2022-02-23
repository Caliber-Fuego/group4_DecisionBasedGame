package com.example.group4_decisionbasedgame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.group4_decisionbasedgame.R;
import com.example.group4_decisionbasedgame.controller.Story;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;

public class HeroStats extends AppCompatActivity implements View.OnClickListener{

    Items items = new Items();
    TextView txtHeroHp, txtWeapon, txtMinDmg, txthpBottle, txtArmor, txtSTR, txtINT, txtCHR, txtDeath, txtBattle;
    Button backButton;

    //Lets the activity call values from PlayerStatus
    PlayerStatus status = new PlayerStatus();
    Story story = new Story(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        //XML IDs for texts and buttons
        txtHeroHp = findViewById(R.id.heroHP);
        txtWeapon = findViewById(R.id.weaponName);
        txtMinDmg = findViewById(R.id.minDmg);
        txtArmor = findViewById(R.id.armornmbr);
        txtSTR = findViewById(R.id.strnmbr);
        txtINT = findViewById(R.id.intnmbr);
        txtCHR = findViewById(R.id.chrnmbr);
        txtDeath = findViewById(R.id.deathnmbr);
        txtBattle = findViewById(R.id.battlenmbr);
        backButton = findViewById(R.id.backButton);



        //Calls values from PlayerStatus
        txtHeroHp.setText(String.valueOf(status.getHeroHPoints() +"/"  +status.getMaxheroHPoints()));
        txtMinDmg.setText(String.valueOf(status.getHeroMinDamage() +" - "+status.getHeroMaxDamage()));
        txtArmor.setText(String.valueOf(status.getArmor()));
        txtSTR.setText(String.valueOf(status.getSTR()));
        txtINT.setText(String.valueOf(status.getINT()));
        txtCHR.setText(String.valueOf(status.getCHR()));
        txtDeath.setText(String.valueOf(story.getDeathCounter()));
        txtBattle.setText(String.valueOf(story.getBattleCounter()));

        txtWeapon.setText(status.name);

        //On Click Listeners
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


