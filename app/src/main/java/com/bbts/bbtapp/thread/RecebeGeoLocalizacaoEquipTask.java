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

public class RecebeGeoLocalizacaoEquipTask extends AsyncTask<Void, Void, String> {

    private Context context;
    private Long id;

    public RecebeGeoLocalizacaoEquipTask(Context context, Long id) {
        this.context = context;
        this.id = id;
    }


    @Override
    protected String doInBackground(Void... params) {

        WebClient client = new WebClient();
        return client.receberGeoLocalizacaoTecnico(id);
    }


    @Override
    protected void onPreExecute() {
//        dialog = ProgressDialog.show(context,"Aguarde","Teste de envio de GeoLocalização", true, true);
    }

    @Override
    protected void onPostExecute(String s) {
        // Equipamento equipamento = new Gson().fromJson(s, Equipamento.class);
    }
}



