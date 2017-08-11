package com.bbts.bbtapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.bbts.bbtapp.R;
import com.bbts.bbtapp.agents.DelatorDeLocalizacao;
import com.bbts.bbtapp.agents.VerificadorDeChamados;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new DelatorDeLocalizacao(this);

        //new VerificadorDeChamados(this);

    }

}
