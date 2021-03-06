package com.example.group4_decisionbasedgame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.group4_decisionbasedgame.R;
import com.example.group4_decisionbasedgame.controller.GameCalculations;
import com.example.group4_decisionbasedgame.controller.Story;
import com.example.group4_decisionbasedgame.model.Items;
import com.example.group4_decisionbasedgame.model.PlayerStatus;
import com.example.group4_decisionbasedgame.model.values.items.item_hpBottle;
import com.example.group4_decisionbasedgame.model.values.weapon.Weapon_Barehand;

public class GameScreen extends AppCompatActivity implements View.OnClickListener {
    public TextView text, hptext, wpntxt, itemqty1;
    public Button btn1, btn2, btn3, btn4, statsbtn;
    public ImageButton itembtn1;
    public ImageView image1;
    public ProgressBar healthbar;

    MediaPlayer player, battle;

    //Allows GameScreen class to call strings from Story class
    Story story = new Story(this);

    //Allows GameScreen class to call variables from HeroStats class
    HeroStats hs = new HeroStats();

    //Allows GameScreen to call values from PlayerStatus
    PlayerStatus status = new PlayerStatus();

    Items item = new Items();

    GameCalculations gc = new GameCalculations();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);


        //XML ids for texts and buttons
        text = (TextView)findViewById(R.id.storyText);
        hptext = (TextView)findViewById(R.id.healthDisplay);
        wpntxt = (TextView)findViewById(R.id.weapondisplayName);
        itemqty1 = (TextView)findViewById(R.id.itemqty1);
        healthbar = (ProgressBar)findViewById(R.id.hpBar);

        btn1 = (Button) findViewById(R.id.btnchoice01);
        btn2 = (Button) findViewById(R.id.btnchoice02);
        btn3 = (Button) findViewById(R.id.btnchoice03);
        btn4 = (Button) findViewById(R.id.btnchoice04);
        itembtn1 = (ImageButton) findViewById(R.id.itembtn1);
        image1 = (ImageView)findViewById(R.id.bgimg);

        //The starting point of the game
        story.startingPoint();
        status = new Weapon_Barehand();
        item = new item_hpBottle();
        player = MediaPlayer.create(this,R.raw.field);
        battle = MediaPlayer.create(this,R.raw.fulcrum);


        //Displays the health points of the player
        hptext.setText(String.valueOf(status.getHeroHPoints()));
        healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));
        wpntxt.setText(status.name);
        itemqty1.setText(String.valueOf(item.getQuantity()));

        itembtn1.setOnClickListener(this);

    }


        //Runs the code to move on to the case placed in the button
    public void btn1 (View view){story.selectPosition(story.nextPosition1);}
    public void btn2 (View view){story.selectPosition(story.nextPosition2);}
    public void btn3 (View view){story.selectPosition(story.nextPosition3);}
    public void btn4 (View view){story.selectPosition(story.nextPosition4);}




    public void viewHeroStats (View v) {
            //Runs the code for the button to move to the HeroStats class
        Intent openHeroStats = new Intent(this, HeroStats.class);
        startActivity(openHeroStats);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.itembtn1:
                //The code for the item button to allow it to run or be disabled
                if(item.getQuantity()>0){
                    status.healHP(status.getHeroHPoints(), item.getHeal());
                    item.setQuantity(item.getQuantity()-1);
                    hptext.setText(String.valueOf(status.getHeroHPoints()));
                    healthbar.setProgress(Integer.parseInt(String.valueOf(status.getHeroHPoints())));
                    itemqty1.setText(String.valueOf(item.getQuantity()));
                } else if (item.getQuantity()==0){
                    itembtn1.setEnabled(false);
                }
                break;
        }
    }


    //Music Related
    public void explorebgm(){
        if( player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this,R.raw.field);
        player.start();
        player.setLooping(true);
    }

    public void battlebgm (){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.fulcrum);
        player.start();
    }
    public void m5endfight (){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.colonelfight);
        player.start();
    }

    public void memorybgm(){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.memory);
        player.start();
        player.setLooping(true);
    }

    public void memory2bgm(){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.memory2);
        player.start();
        player.setLooping(true);
    }

    public void memory4bgm(){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.memory3);
        player.start();
    }
    public void memory5bgm(){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.nighttime);
        player.setLooping(true);
        player.start();
    }

    public void m5endbgm(){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.colonelroom);
        player.start();
    }

    public void vincent(){
        if (player.isPlaying()){
            player.pause();
        }
        player = MediaPlayer.create(this, R.raw.rebellion);
        player.start();
    }

    public void slashsoundeffect(){
        battle = MediaPlayer.create(this, R.raw.slash);
        battle.start();
    }

    public void enemyattacksfx(){
        battle = MediaPlayer.create(this, R.raw.enemyattack);
        battle.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (player.isPlaying()) {
            player.pause();
        }if (player.isLooping()){
            player.pause();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        player.start();
    }
}