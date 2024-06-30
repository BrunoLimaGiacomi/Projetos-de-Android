package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity2 extends AppCompatActivity {
private TextView lbllogin;
private TextView lblsenha;
private ImageView foto;

    public String Host = "https://aulateste3.000webhostapp.com/projeto/";

    public String url;
    public String ret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lbllogin=(TextView) findViewById(R.id.lbllogin);
        lblsenha=(TextView) findViewById(R.id.lblsenha);
        foto=(ImageView) findViewById(R.id.foto);
        lbllogin.setText(MainActivity.loginx);
        lblsenha.setText(MainActivity.senhax);
        Ion.with(foto).placeholder(R.drawable.vazio).error(R.drawable.vazio).load(
                "https://aulateste3.000webhostapp.com/projeto/imagem/" + MainActivity.fotox + "");
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            deletar();
            }
        });
    }

    private void deletar()
    {
        url = Host + "deletar.php";
        Ion.with(MainActivity2.this)
                .load(url)
                .setBodyParameter("usuario", MainActivity.loginx)
                .setBodyParameter("senha",MainActivity.senhax)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        ret = result.get("status").getAsString();
                        if (ret.equals("ok")) {
                            Toast.makeText(getApplicationContext(), " Excluido com sucesso", Toast.LENGTH_LONG).show();

                        } else {
                            Toast.makeText(getApplicationContext(), " erro", Toast.LENGTH_LONG).show();

                        }


                    }
                });
    }
}