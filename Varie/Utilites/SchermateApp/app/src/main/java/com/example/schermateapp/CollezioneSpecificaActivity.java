package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CollezioneSpecificaActivity extends AppCompatActivity {

    ImageButton modificaDescrizione;
    ImageButton backButton;
    EditText descrizione;
    Button salvaDescrizione;
    Button eliminaCollezione;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collezione_specifica);

        modificaDescrizione = (ImageButton) findViewById(R.id.imageButtonEditDescrizione);
        backButton = (ImageButton) findViewById(R.id.backButtonAcCollezioneSpecifica);
        descrizione = (EditText) findViewById(R.id.editTextDescrizioneCollezione);
        salvaDescrizione = (Button) findViewById(R.id.buttonSalvaModificheDescrizione);
        eliminaCollezione = (Button) findViewById(R.id.buttonEliminaCollezione);

        salvaDescrizione.setVisibility(View.INVISIBLE);
        descrizione.setEnabled(false);

        modificaDescrizione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaDescrizione.setVisibility(View.VISIBLE);
                descrizione.setEnabled(true);
            }
        });



    }
}