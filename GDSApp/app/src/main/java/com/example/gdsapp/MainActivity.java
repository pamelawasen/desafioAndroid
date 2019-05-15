package com.example.gdsapp;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botao = findViewById(R.id.btnConsultar);
        final TextView resposta = findViewById(R.id.textResposta);




        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask asyncTask = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url("https://gdscartao.com.br/nicolau-kerpen?querycard=15420003466&pin=YMON5BHOQM&qcapi")
                                .build();
                        Response response = null;
                        try{
                            response = client.newCall(request).execute();
                            return response.body().string();

                        }catch (IOException e){
                            e.printStackTrace();
                        }

                        return null;
                    }
                    @Override
                    protected void onPostExecute(Object o){
                        resposta.setText(o.toString());
                    }
                }.execute();
            }
        });
    }
}

        /*final TextView resposta = findViewById(R.id.textResposta);
        final EditText numerocartao = findViewById(R.id.editNumberCard);

        Button botao = findViewById(R.id.btnConsultar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Service service = new  Service(numerocartao.getText().toString());
                try {
                    ListaAPI retorno = service.execute().get();
                    resposta.setText(retorno.toString());

                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}*/

