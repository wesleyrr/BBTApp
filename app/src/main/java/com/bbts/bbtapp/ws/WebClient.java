package com.bbts.bbtapp.ws;

import com.bbts.bbtapp.model.Tecnico;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by wesley on 12/06/17.
 */

public class WebClient {

    private  Tecnico tecnico;
    private String resposta;


    public String enviarGeoLocalizacaoTecnico(Tecnico tecnico) {

        this.tecnico = tecnico;

        try {

            URL url = new URL("http://192.168.0.108/hackatapp/atualiza_localizacao.php?funcionario=" + tecnico.getId() +
                    "&lat=" + tecnico.getLatitudeAtual() +
                    "&long=" + tecnico.getLongitudeAtual());

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


    public String receberGeoLocalizacaoTecnico(Long id) {

        try {

            URL url = new URL("http://192.168.0.108/hackatapp/servico.php?funcionario=" + id);

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