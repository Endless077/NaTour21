package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ProfiloActivity extends AppCompatActivity {

    ImageButton backButton;
    Button logoutButton;
    Button galleriaButton;
    Button cameraButton;
    Button confermaButton;
    ImageView fotoProfilo;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    private final int REQUEST_PERMISSIONS_REQUEST_CODE_POSITION = 2;
    private final int PICK_IMAGE = 1;
    private final int CAMERA = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);

        backButton = (ImageButton) findViewById(R.id.imageButtonBack);
        logoutButton = (Button) findViewById(R.id.buttonLogOutAcProfilo);
        galleriaButton = (Button) findViewById(R.id.buttonScegliFotoAcProfilo);
        cameraButton = (Button) findViewById(R.id.buttonCameraAcProfilo);
        confermaButton = (Button) findViewById(R.id.buttonConfermaModificheAcProfilo);
        fotoProfilo = (ImageView) findViewById(R.id.imageViewFotoProfiloAcProfilo);

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

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(ProfiloActivity.this, HomePageActivity.class);
                //extra
                startActivity(newIntent);
            }
        });

        confermaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(ProfiloActivity.this, LoginActivity.class);
                startActivity(newIntent);
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