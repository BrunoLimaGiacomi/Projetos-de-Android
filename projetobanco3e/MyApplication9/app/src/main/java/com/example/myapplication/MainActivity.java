package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
     public String Host = "https://aulateste3.000webhostapp.com/projeto/";

    public String url;
    public String ret;
    private EditText txtlogin;
    private EditText txtsenha;
     public static String loginx , senhax,fotox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtlogin=(EditText) findViewById(R.id.txtlogin);
        txtsenha=(EditText) findViewById(R.id.txtsenha);

        findViewById( R.id.button ).setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                inserir();


            }
        } );
 findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         logar();
     }
 });


    }

public void logar()
{
    url=Host+"login.php";
    Ion.with (MainActivity.this)
            .load ( url )
            .setBodyParameter ( "usuario" ,txtlogin.getText ().toString ())
            .setBodyParameter ( "senha",txtsenha.getText () .toString ())
            .asJsonObject ()
            .setCallback ( new FutureCallback<JsonObject> () {
                @Override
                public void onCompleted(Exception e, JsonObject result) {
                    ret=result.get("status").getAsString ();
                    if(ret.equals ("ok"))
                    {
                        loginx=txtlogin.getText().toString();
                        senhax=txtsenha.getText().toString();
                        fotox=result.get("foto").getAsString().toString();
                            Intent trocar=new Intent(MainActivity.this,MainActivity2.class);
                        MainActivity.this.startActivity(trocar);


                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),
                                " não existe login ou senha ",   Toast.LENGTH_LONG).show();

                    }


                }
            } );

}


    public void inserir() {

        url = Host + "inserirt.php";
        Ion.with(MainActivity.this)
                .load(url)
                .setBodyParameter("usuario", txtlogin.getText().toString())
                .setBodyParameter("senha", txtsenha.getText().toString())
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if (ret.equals("ok")) {
                            Toast.makeText(getApplicationContext(), " incluido com sucesso", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), " erro", Toast.LENGTH_LONG).show();

                        }


                    }
                });
    }


    }



