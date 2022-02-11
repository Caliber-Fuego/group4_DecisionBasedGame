package com.example.group4_decisionbasedgame.view;

import static com.example.group4_decisionbasedgame.R.id.invSlot1;
import static com.example.group4_decisionbasedgame.R.id.invSlot4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.group4_decisionbasedgame.R;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;

public class HeroStats extends AppCompatActivity implements View.OnClickListener{

    Items items = new Items();
    TextView txtHeroHp, txtWeapon, txtMinDmg, txthpBottle, txtArmor;
    Button backButton;
    public ImageButton slot1, slot4;

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
        txthpBottle = findViewById(R.id.hpbottleamt);
        txtArmor = findViewById(R.id.armornmbr);

        backButton = findViewById(R.id.backButton);

        slot1 = findViewById(invSlot1);
        slot4 = findViewById(invSlot4);


        //Calls values from PlayerStatus
        txtHeroHp.setText(String.valueOf(status.getHeroHPoints() +"/"  +status.getMaxheroHPoints()));
        txtMinDmg.setText(String.valueOf(status.getHeroMinDamage() +" - "+status.getHeroMaxDamage()));
        txtArmor.setText(String.valueOf(status.getArmor()));
        txtWeapon.setText(status.name);
        txthpBottle.setText(String.valueOf(items.getQuantity()));


        //Sets onclicklisteners for the buttons
        slot1.setOnClickListener(this);
        slot4.setOnClickListener(this);
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


