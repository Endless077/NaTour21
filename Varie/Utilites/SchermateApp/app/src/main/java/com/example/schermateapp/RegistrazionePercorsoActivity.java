package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegistrazionePercorsoActivity extends AppCompatActivity {

    ImageButton backButton;
    Button avviaButton;
    Button stopButton;
    Button pubblicaButton;
    Button annullaButton;
    Chronometer cronometro;
    long timeWhenStopped = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione_percorso);


        backButton = (ImageButton) findViewById(R.id.backButtonAcRegistrazionePercorso);
        avviaButton = (Button) findViewById(R.id.buttonAvviaCronometro);
        stopButton = (Button) findViewById(R.id.buttonStopCronometro);
        pubblicaButton = (Button) findViewById(R.id.buttonPubblica);
        annullaButton = (Button) findViewById(R.id.buttonAnnullaCronometro);
        cronometro = (Chronometer) findViewById(R.id.Cronometro);


        avviaButton.setEnabled(true);
        stopButton.setEnabled(false);

        avviaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avviaButton.setEnabled(false);
                stopButton.setEnabled(true);
                if(timeWhenStopped == 0) {
                    cronometro.setBase(SystemClock.elapsedRealtime());
                    cronometro.start();
                }else{
                    cronometro.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    cronometro.start();
                }
                pubblicaButton.setVisibility(View.INVISIBLE);
                annullaButton.setVisibility(View.INVISIBLE);
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                avviaButton.setEnabled(true);
                stopButton.setEnabled(false);
                timeWhenStopped = cronometro.getBase() - SystemClock.elapsedRealtime();
                cronometro.stop();
                pubblicaButton.setVisibility(View.VISIBLE);
                annullaButton.setVisibility(View.VISIBLE);
            }
        });

        pubblicaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        annullaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}