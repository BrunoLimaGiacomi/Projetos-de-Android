package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.gotev.uploadservice.MultipartUploadRequest;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
public TextView lblnome;
public static String UPLOAD_URL="https://aulateste3.000webhostapp.com//projeto//upload.php";

//public static String UPLOAD_URL="http://192.168.15.2/projeto/upload.php";


    private int PICK_IMAGE_REQUEST=2;
private static int STORAGE_PERMISSION_CODE=123;
private Bitmap bitmap;
private Uri filepath;
private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        requestStoragePermission();

imageView=(ImageView)findViewById ( R.id.imageView );
lblnome=(TextView)findViewById ( R.id.lblnome );

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
               escolherfoto();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                enviarfoto();
            }
        });



    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

        }

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {


        if (requestCode == STORAGE_PERMISSION_CODE) {


            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                Toast.makeText(this, "permissão concedida agora você pode ler o armazenamento", Toast.LENGTH_LONG).show();
            } else {

                Toast.makeText(this, "Permissão negada", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void escolherfoto()
    {
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction ( Intent.ACTION_GET_CONTENT );
        startActivityForResult ( Intent.createChooser ( intent,"Selecione a figura" ), PICK_IMAGE_REQUEST);


    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        super.onActivityResult ( requestCode,resultCode,data );
        if(requestCode==PICK_IMAGE_REQUEST && resultCode==RESULT_OK && data!=null & data.getData()!=null) {
            filepath = data.getData ();
            String path = getPath ( filepath );
            String nomearq = new File ( path ).getName ();
           long tam=new File ( path ).length ();
            lblnome.setText ( nomearq.toString ()+"    "+    tam+"" );
            Toast.makeText ( getApplicationContext (), nomearq, Toast.LENGTH_LONG ).show ();
            try {
                bitmap = MediaStore.Images.Media.getBitmap( getContentResolver (), filepath );
                imageView.setImageBitmap ( bitmap );
            }
            catch (IOException e)
            {
                e.printStackTrace ();


            }
        }
            }

    public String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();

        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;
    }

    private void  enviarfoto()
    {
        String name = lblnome.getText().toString().trim();


        String path = getPath(filepath);

        try {
            String uploadId = UUID.randomUUID().toString();


            Toast.makeText(this, uploadId+"   "+ name +"   "+ path, Toast.LENGTH_SHORT).show();

            new MultipartUploadRequest (this, uploadId, UPLOAD_URL)
                    .addFileToUpload(path, "image") //arquivo
                    .addParameter("name", name)
                    .setMaxRetries(2)
                    .startUpload(); //começando o upload

        } catch (Exception exc) {
            Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }






}







