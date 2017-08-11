package com.bbts.bbtapp.ws;

import com.bbts.bbtapp.model.Tecnico;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by wesley on 12/06/17.
 */

public class WebClient2 {

    private String resposta;


    public String buscarGeoLocalizacaoEquipamento(Long id) {
        //   URL url = new URL("http://192.168.1.101/hackatapp/servico.php?funcionario=" + tecnico.getId()

        try {

            URL url = new URL("http://192.168.0.108/hackatapp/servico.php?funcionario=3" ) ;

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            try {
                InputStream in = new BufferedInputStream(connection.getInputStream());

                Scanner scanner = new Scanner(in);
                resposta = scanner.next();
            } finally {
                connection.disconnect();
            }

            return resposta;

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

}