package com.bbts.bbtapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.bbts.bbtapp.R;
import com.bbts.bbtapp.fragment.MapaFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

public class MapaActivity extends AppCompatActivity {


    private FragmentManager manager;
    private FragmentTransaction tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        manager = getSupportFragmentManager();
        tx = manager.beginTransaction();
        tx.replace(R.id.frame_mapa, new MapaFragment());
        tx.commit();

    }

}
