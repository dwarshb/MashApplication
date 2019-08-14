package com.dwarsh.mashapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

public class SecondActivity extends Activity {
    RecyclerView gameslistvw;
    ArrayList<Games> games = new ArrayList<>();
    GAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        Animation translate = AnimationUtils.loadAnimation(this,R.anim.translate);
        Animation fadein = AnimationUtils.loadAnimation(this,R.anim.fadein);
        findViewById(R.id.dashboard).startAnimation(fadein);
        gameslistvw = (RecyclerView)findViewById(R.id.gameslist);
        gameslistvw.startAnimation(translate);
        gameslistvw.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GAdapter(this,games);
        gameslistvw.setAdapter(adapter);
        getGames();
    }
    public void getGames()
    {
        Games games1 = new Games("Moonwalk","Complete the Sentence","3677",R.drawable.moonwalk);
        Games games2 = new Games("Pillar Game","Match the Defination","2484",R.drawable.pillargames);
        Games games3 = new Games("Spelling","Choose the correct spelling","5031",R.drawable.spelling);
        Games games4 = new Games("Swipe","Find the verbs or nouns","1261",R.drawable.swipe);
        games.add(games1);
        games.add(games2);
        games.add(games3);
        games.add(games4);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SecondActivity.this,MainActivity.class));
    }
}
