package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends Activity {
    public String Host="https://aulateste3.000webhostapp.com/projeto/";
    public String url;
    public List<String> listaprod;
    public static List<String> listacod,listanome,listafoto;
    public ArrayAdapter<String> adap;

public static int posicao;
    public ListView lista;
    private EditText txtpesq;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );
        lista=(ListView)findViewById( R.id.lista );
        listacod=new ArrayList<String>();
        listanome=new ArrayList<String>();
        listafoto=new ArrayList<String>();
        listaprod=new ArrayList<String>();

                listarprodutos();




        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
            posicao=position;
                Intent trocar=new Intent(MainActivity3.this,MainActivity4.class);
                MainActivity3.this.startActivity(trocar);
             //Toast.makeText(getApplicationContext(),
               // ((TextView) view).getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void listarprodutos()
    {
        url=Host+"listarp.php";
        Ion.with(getBaseContext())
                .load(url)

                .asJsonArray()
                .setCallback( new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                      listaprod.clear();
                        listacod.clear();
                        listanome.clear();
                        listafoto.clear();
                        for(i=0;i<result.size();i++)
                        {
                            JsonObject retx=result.get( i ).getAsJsonObject();
                            listaprod.add( retx.get( "cod" ).getAsString().toString()+ " "+
                                    retx.get( "nome" ).getAsString().toString()+
                                    "  "+ retx.get( "preco" ).getAsString().toString()+"  "+
                                    retx.get("foto").getAsString().toString());
                           listacod.add(retx.get( "cod" ).getAsString().toString());
                            listanome.add(  retx.get( "nome" ).getAsString().toString());
                            listafoto.add( retx.get("foto").getAsString().toString());

                        }
                        adap=new ArrayAdapter<String>( MainActivity3.this,
                                android.R.layout.simple_list_item_1,listaprod );
                        adap.setDropDownViewResource(android.R.layout.simple_list_item_checked );
                        lista.setAdapter( adap );
                    }
                } );



    }
}
