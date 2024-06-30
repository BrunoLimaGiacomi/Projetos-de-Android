package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNome, txtCurso;
    Button btnSalvar;

    //classe do BD que faz todas as operações do db
    SQLiteDatabase dbShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSalvar = (Button) findViewById(R.id.btnSalvar);


        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //chamando metodo botao
                Gravar();
            }
        });
        //Chamando o metodo para abrir o BD
        db();

    }
    //evento botao


    //metodo
    public void db()
    {
      String sql;
      try
      {
          //Criando a tabela, caso a mesma nao exista
          sql ="CREATE TABLE IF NOT EXISTS ALUNOS("+"matricula INTEGER PRIMARY KEY AUTOINCREMENT," +
                   "Nome TEXT," +
                   "Curso TEXT)";

          //Criando/Abrindo DB

          dbShow = openOrCreateDatabase("ETEC",MODE_PRIVATE,null);

          //Executando a query
          
          dbShow.execSQL(sql);
          
          //Mostrando menssagem de sucesso

          Toast.makeText(MainActivity.this, "Sistema Carregado com sucesso",
                         Toast.LENGTH_SHORT).show();

      }
      catch(Exception erro)
      {

          //se ocorrer um erro

          Toast.makeText(MainActivity.this, "Erro ao carregar sistema: "+erro.getMessage(),
                          Toast.LENGTH_SHORT).show();

      }
    }//CriarAbrirDB
    public void Gravar()
    {
        txtNome = (EditText) findViewById(R.id.txtNome);
        txtCurso = (EditText) findViewById(R.id.txtCurso);
        String sql;

        try
        {
            sql= "INSERT INTO Alunos(Nome,Curso)VALUES('"+txtNome.getText().toString()+"'," +
                                                      "'"+txtCurso.getText().toString()+"')";

            //Executando querry

            dbShow.execSQL(sql);

            Toast.makeText(MainActivity.this, "Alunos inseridos com sucesso", Toast.LENGTH_SHORT).show();
        }
        catch(Exception erro)
        {
            Toast.makeText(MainActivity.this, "Erro ao inserir Aluno: "+erro.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }//Gravar
}//MainActivity