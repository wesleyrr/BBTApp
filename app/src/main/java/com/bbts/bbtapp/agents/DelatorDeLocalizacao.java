package com.bbts.bbtapp.agents;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.bbts.bbtapp.model.Tecnico;
import com.bbts.bbtapp.thread.EnviaGeoLocalizacaoTask;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by wesley on 12/06/17.
 */


public class DelatorDeLocalizacao implements GoogleApiClient.ConnectionCallbacks, LocationListener {

    private final GoogleApiClient client;
    private final Context context;
    private Location location;
    private Tecnico tecnico;


    public DelatorDeLocalizacao(Context context) {
        client = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .build();

        client.connect();

        this.context = context;

        if(this.tecnico == null){
            this.tecnico = new Tecnico();
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        LocationRequest request = new LocationRequest();
        //request.setSmallestDisplacement(20); //atualizar a cada 20 metros
        //TODO AVALIAR FUTURAMENTE CRITÉRIO DE ATUALIZAÇÃO
        request.setInterval(5000); // a cada 5 segundos
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationServices.FusedLocationApi.requestLocationUpdates(client, request, this);
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    //ENVIA A LOCALIZAÇÃO PARA O SERVIDOR A CADA 5 SEGUNDOS
    @Override
    public void onLocationChanged(Location location) {
        this.location = location;

        this.tecnico.setId(3L);
        this.tecnico.setLatitudeAtual(location.getLatitude());
        this.tecnico.setLongitudeAtual(location.getLongitude());

        LatLng coordenada = new LatLng(location.getLatitude(), location.getLongitude());

        new EnviaGeoLocalizacaoTask(context, this.tecnico).execute();
    }


}