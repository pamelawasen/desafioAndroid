package com.example.gdsapp;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Service extends AsyncTask<Void,Void,ListaAPI> {

    private final String lista;

    public Service(String lista) {
        this.lista = lista;
    }

    @Override
    protected ListaAPI doInBackground(Void... voids) {

        StringBuilder resposta = new StringBuilder();

        try {
           URL url = new URL("https://gdscartao.com.br/nicolau-kerpen?querycard=15420003466&pin=YMON5BHOQM&qcapi");
            HttpURLConnection conection = (HttpURLConnection) url.openConnection();
            conection.setRequestMethod("GET");
            conection.setRequestProperty("Accept","application/json");
            //conection.setConnectTimeout(5000);
            conection.connect();

            // pega a ressposta e transforma em uma stram
            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()){
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(),ListaAPI.class);
    }
}
