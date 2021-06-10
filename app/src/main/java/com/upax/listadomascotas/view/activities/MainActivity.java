package com.upax.listadomascotas.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.upax.listadomascotas.R;
import com.upax.listadomascotas.view.activities.views.MainActivityView;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzaFragment(new MascotasFragment());
    }

    public void lanzaFragment(Fragment fragment){
        FragmentManager fManager = getFragmentManager();
        FragmentTransaction fTransaction = fManager.beginTransaction();
        fTransaction.replace(R.id.fragmentLayout, fragment);
        fTransaction.commit();
    }

}