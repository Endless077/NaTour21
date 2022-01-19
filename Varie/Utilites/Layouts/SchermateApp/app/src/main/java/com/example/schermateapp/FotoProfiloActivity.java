package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FotoProfiloActivity extends AppCompatActivity {

    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE_POSITION = 2;
    private final int PICK_IMAGE = 1;
    private final int CAMERA = 2;


    String nome = "";
    String cognome = "";
    String email = "";
    String password = "";

    ImageView fotoProfilo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto_profilo);



        Intent nowIntent = getIntent();
        if(nowIntent != null){
            nome = nowIntent.getStringExtra("nome");
            cognome = nowIntent.getStringExtra("cognome");
            email = nowIntent.getStringExtra("email");
            password = nowIntent.getStringExtra("password");
        }


        ImageButton backButton = (ImageButton) findViewById(R.id.backButtonAcCollezioneSpecifica);
        fotoProfilo = (ImageView) findViewById(R.id.imageViewFotoProfilo);
        Button galleriaButton = (Button) findViewById(R.id.buttonScegliFotoAcProfilo);
        Button registratiButton = (Button) findViewById(R.id.buttonRegistrati);
        Button cameraButton = (Button) findViewById(R.id.buttonCameraAcProfilo);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = (Intent) new Intent(FotoProfiloActivity.this, RegistrazioneActivity.class);
                newIntent.putExtra("nome", nome);
                newIntent.putExtra("cognome", cognome);
                newIntent.putExtra("email", email);
                newIntent.putExtra("password", password);
                startActivity(newIntent);
            }
        });

        galleriaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[] {pickIntent});

                startActivityForResult(chooserIntent, PICK_IMAGE);

            }
        });

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePicture, CAMERA);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE) {
            fotoProfilo.setImageURI(data.getData());
        }else if(requestCode == CAMERA){
            fotoProfilo.setImageURI(data.getData());
        }

    }
}