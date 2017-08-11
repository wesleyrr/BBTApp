package com.bbts.bbtapp.thread;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.bbts.bbtapp.model.Tecnico;
import com.bbts.bbtapp.ws.WebClient;

/**
 * Created by wesley on 12/06/17.
 */

public class EnviaGeoLocalizacaoTask extends AsyncTask <Void, Void, String> {

    private final Tecnico tecnico;
    private Context context;


    public EnviaGeoLocalizacaoTask(Context context, Tecnico tecnico) {
        this.context = context;
        this.tecnico = tecnico;
    }


    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        return client.enviarGeoLocalizacaoTecnico(tecnico);
    }


    @Override
    protected void onPreExecute() {
    }

    @Override
    protected void onPostExecute(String s) {
    }
}



