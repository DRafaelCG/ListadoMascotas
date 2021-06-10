package com.upax.listadomascotas.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import com.upax.listadomascotas.R;
import com.upax.listadomascotas.view.activities.views.SplashActivityView;

public class SplashActivity extends AppCompatActivity implements SplashActivityView {
    protected boolean active = true;
    protected int splashTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ajustaPantalla();
        setContentView(R.layout.activity_splash);
        lanzaSplash();
    }

    public void lanzaSplash(){
        Thread splashThread = new Thread(){
            @Override
            public void run(){
                try {
                    int waited = 0;
                    while (active && (waited < splashTime)){
                        sleep(100);
                        if(active){
                            waited += 100;
                        }
                    }
                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }finally {
                    openApp();
                }
            }
        };
        splashThread.start();
    }

    public void ajustaPantalla(){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void openApp(){
        Intent inicio = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(inicio);
        finish();
    }

}