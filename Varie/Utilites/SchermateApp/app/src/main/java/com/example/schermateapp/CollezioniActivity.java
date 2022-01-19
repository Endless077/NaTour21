package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CollezioniActivity extends AppCompatActivity {

    ImageButton backButton;
    Button buttonNuovaCollezione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collezioni);

        backButton = (ImageButton) findViewById(R.id.backButtonAcCollezioneSpecifica);
        buttonNuovaCollezione = (Button) findViewById(R.id.buttonInserisciNuovaCollezione);

        buttonNuovaCollezione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(CollezioniActivity.this, NuovaCollezioneActivity.class);
                //extra
                startActivity(newIntent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}