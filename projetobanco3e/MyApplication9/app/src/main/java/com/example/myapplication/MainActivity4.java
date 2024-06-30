package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;

public class MainActivity4 extends AppCompatActivity {
private TextView lblcod,lblnome;
private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        lblcod=(TextView) findViewById(R.id.lblcod);
        lblnome=(TextView) findViewById(R.id.lblnome);
        foto=(ImageView) findViewById(R.id.foto);
        lblcod.setText(MainActivity3.listacod.get(MainActivity3.posicao));
        lblnome.setText(MainActivity3.listanome.get(MainActivity3.posicao));
        Ion.with(foto).placeholder(R.drawable.vazio).error(R.drawable.vazio).load(
                "https://aulateste3.000webhostapp.com/projeto/imagem/" +
                        MainActivity3.listafoto.get(MainActivity3.posicao) + "");


    }
}