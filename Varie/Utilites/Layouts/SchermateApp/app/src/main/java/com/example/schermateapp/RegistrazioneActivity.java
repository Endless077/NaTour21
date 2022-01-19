package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegistrazioneActivity extends AppCompatActivity {

    String nome = "";
    String cognome = "";
    String email = "";
    String password = "";
    String confermaPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrazione_activity);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButtonAcCollezioneSpecifica);
        Button registratiButton = (Button) findViewById(R.id.avantiButton);

        CheckBox terminiServiziCheckBox = (CheckBox) findViewById(R.id.checkBoxTerminiServizi);

        EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
        EditText editTextCognome = (EditText) findViewById(R.id.editTextCognome);
        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        EditText editTextConfermaPassword = (EditText) findViewById(R.id.editTextConfermaPassword);

        TextView twNomeErrato = (TextView) findViewById(R.id.textViewNomeErrato);
        TextView twCognomeErrato = (TextView) findViewById(R.id.textViewCognomeErrato);
        TextView twIndirizzoEmailErrato = (TextView) findViewById(R.id.textViewIndirizzoEmailErrato);
        TextView twPasswordErrata = (TextView) findViewById(R.id.textViewPasswordErrata);
        TextView twPasswordNonCoincidono = (TextView) findViewById(R.id.textViewPasswordNonCoincidono);
        TextView twCheckBox = (TextView) findViewById(R.id.textViewTerminiServizi);

    //[a-zA-Z\s]+
        //^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$

        Intent nowIntent = getIntent();
        if(nowIntent!=null){
            editTextNome.setText(nowIntent.getStringExtra("nome"));
            editTextCognome.setText(nowIntent.getStringExtra("cognome"));
            editTextEmail.setText(nowIntent.getStringExtra("email"));
            editTextPassword.setText(nowIntent.getStringExtra("password"));
            editTextConfermaPassword.setText(nowIntent.getStringExtra("password"));
        }

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(RegistrazioneActivity.this, LoginActivity.class);
                startActivity(newIntent);
            }
        });

        registratiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = editTextNome.getText().toString();
                cognome = editTextCognome.getText().toString();
                email= editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                confermaPassword = editTextConfermaPassword.getText().toString();
                boolean flag = terminiServiziCheckBox.isChecked();
                boolean correct = true;

                twNomeErrato.setVisibility(View.INVISIBLE);
                twCognomeErrato.setVisibility(View.INVISIBLE);
                twIndirizzoEmailErrato.setVisibility(View.INVISIBLE);
                twPasswordErrata.setVisibility(View.INVISIBLE);
                twPasswordNonCoincidono.setVisibility(View.INVISIBLE);
                twCheckBox.setVisibility(View.INVISIBLE);


                if((nome.isEmpty()) || (!nome.matches("[a-zA-Z\\s]+"))){
                    twNomeErrato.setVisibility(View.VISIBLE);
                    correct = false;
                }
                if((cognome.isEmpty()) || (!cognome.matches("[a-zA-Z\\s]+"))){
                    twCognomeErrato.setVisibility(View.VISIBLE);
                    correct = false;
                }
                if((email.isEmpty()) || (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))){
                    twIndirizzoEmailErrato.setVisibility(View.VISIBLE);
                    correct = false;
                }
                if((password.isEmpty()) || (!password.matches("[a-zA-Z0-9]+"))){
                    twPasswordErrata.setVisibility(View.VISIBLE);
                    correct = false;
                }
                if((password.isEmpty()) || (confermaPassword.isEmpty()) || (!password.equals(confermaPassword))){
                    twPasswordNonCoincidono.setVisibility(View.VISIBLE);
                    correct = false;
                }
                if(flag == false){
                    twCheckBox.setVisibility(View.VISIBLE);
                    correct = false;
                }

                if(correct){

                    Intent newIntent = (Intent) new Intent(RegistrazioneActivity.this, FotoProfiloActivity.class);
                    newIntent.putExtra("nome", nome);
                    newIntent.putExtra("cognome", cognome);
                    newIntent.putExtra("email", email);
                    newIntent.putExtra("password", password);
                    startActivity(newIntent);
                }


            }
        });
    }
}