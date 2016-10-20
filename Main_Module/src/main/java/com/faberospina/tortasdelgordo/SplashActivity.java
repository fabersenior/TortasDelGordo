package com.faberospina.tortasdelgordo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final  long SPLAS_DELAY=3000;
    String name,pass,correo;

    private  int LOG;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        prefs= PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor=prefs.edit();

        LOG=prefs.getInt("Logged",-1);

        final ContactosSQLHelper UDB = new ContactosSQLHelper(this,"TortasBD",null,1);

        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        rep();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                if (LOG==1){

                    Intent intent = new Intent(getApplicationContext(),Main1Activity.class);
                    startActivity(intent);
                    finish();

                }else {

                    Intent i = new Intent().setClass(SplashActivity.this, LoginActivity.class);//loginActivtty
                    startActivity(i);
                    finish();
                }
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,SPLAS_DELAY);



    }

    public  void rep(){

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        correo = prefs.getString("kEmail","07");
        name = prefs.getString("kName","07");
        pass = prefs.getString("kPass","07");
    }
}
