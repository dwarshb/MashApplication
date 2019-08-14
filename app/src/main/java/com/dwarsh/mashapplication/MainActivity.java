package com.dwarsh.mashapplication;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    LinearLayout practicelay;
    ImageView triangle;
    CardView boyimg;
    TextView pract,pracd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        triangle = (ImageView)findViewById(R.id.triangle);
        boyimg = (CardView)findViewById(R.id.imagevw);
        pract = (TextView)findViewById(R.id.practitle);
        pracd = (TextView)findViewById(R.id.pracdesc);
        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 100);
        animation.setDuration(1000); // in milliseconds
        animation.start();
        animation.setInterpolator(new DecelerateInterpolator());
        findViewById(R.id.activity_main).animate().setStartDelay(2);
        practicelay = (LinearLayout)findViewById(R.id.practice_lay);
        practicelay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animtringle = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.triangle);
                animtringle.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        triangle.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                Animation animzo = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.zoomout);
                Animation bottomnav = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.bottomnav);
                final Animation animfade = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fadeout);
                animfade.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        findViewById(R.id.profvw).setVisibility(View.GONE);
                        findViewById(R.id.videotip).setVisibility(View.GONE);
                        findViewById(R.id.news).setVisibility(View.GONE);
                        findViewById(R.id.videolsn).setVisibility(View.GONE);
                        findViewById(R.id.title).setVisibility(View.GONE);
                        findViewById(R.id.news).setVisibility(View.GONE);
                        practicelay.setOrientation(LinearLayout.HORIZONTAL);
                        pract.setPadding(10,0,10,0);
                        practicelay.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                                startActivity(new Intent(MainActivity.this,SecondActivity.class));
                            }
                        },2000);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                triangle.startAnimation(animtringle);
                boyimg.startAnimation(animzo);
                findViewById(R.id.profvw).startAnimation(animfade);
                findViewById(R.id.profile).startAnimation(animfade);
                findViewById(R.id.videolsn).startAnimation(animfade);
                findViewById(R.id.news).startAnimation(animfade);
                findViewById(R.id.videotip).startAnimation(animfade);
                findViewById(R.id.title).startAnimation(animfade);
                findViewById(R.id.navigation).startAnimation(bottomnav);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
