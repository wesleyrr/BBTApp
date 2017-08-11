package com.bbts.bbtapp.fragment;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.bbts.bbtapp.R;
import com.bbts.bbtapp.activities.MapaActivity;
import com.bbts.bbtapp.utils.Localizador;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Created by wesley on 12/06/17.
 */


public class MapaFragment extends SupportMapFragment implements OnMapReadyCallback
        , GoogleMap.OnCameraMoveStartedListener {

    private MarkerOptions marcador;
    //private int estiloMapa = 1;

    private GoogleMap googleMap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args != null && !args.isEmpty()) {
            //estiloMapa = args.getInt("tipo");
        }

        getMapAsync(this); //método assíncrono que retorna um mapa para o método onMapReady quando terminar
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap = googleMap;
        this.googleMap.setOnCameraMoveStartedListener(this);

        this.googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(getContext(), R.raw.style_json));


        LatLng posicaoInicial = pegaCoordenadaDoEndereco("SMLN MI 3 Conjunto 4 Casa 31 - Lago Norte, Brasília - DF, 71540-035");
        if (posicaoInicial != null) {
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(posicaoInicial, 13);
            this.googleMap.moveCamera(update);
        }


        new Localizador(getContext(), this.googleMap, (MapaActivity) getActivity());
    }


    private LatLng pegaCoordenadaDoEndereco(String endereco) {
        try {
            Geocoder geocoder = new Geocoder(getContext());
            List<Address> resultados =
                    geocoder.getFromLocationName(endereco, 1);
            if (!resultados.isEmpty()) {
                LatLng posicao = new LatLng(resultados.get(0).getLatitude(), resultados.get(0).getLongitude());
                return posicao;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void onCameraMoveStarted(int reason) {

        /*if (reason == GoogleMap.OnCameraMoveStartedListener.REASON_GESTURE) {
            Toast.makeText(getContext(), "O usuário usou gesto no mapa.", Toast.LENGTH_SHORT).show();
        }
        //Toast.makeText(getContext(),"zoom: " + googleMap.getCameraPosition().zoom, Toast.LENGTH_SHORT).show();
        Toast.makeText(getContext(),"latlng: " + googleMap.getProjection().getVisibleRegion(), Toast.LENGTH_LONG).show();*/

    }

    private LatLngBounds getLatLngBounds(){

        googleMap.getProjection().getVisibleRegion();

        return null;
    }

}
