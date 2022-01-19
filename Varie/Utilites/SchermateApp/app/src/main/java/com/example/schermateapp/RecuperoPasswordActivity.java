package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class RecuperoPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupero_password);

        ImageButton backButton = (ImageButton) findViewById(R.id.backButtonAcCollezioneSpecifica);
        EditText email = (EditText) findViewById(R.id.editTextEmail);
        Button inviaButton = (Button) findViewById(R.id.InviaButton);
        TextView twCampoEmailVuoto = (TextView) findViewById(R.id.textViewCampoEmailVuoto);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(RecuperoPasswordActivity.this, LoginActivity.class);
                startActivity(newIntent);
            }
        });

        inviaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInserita = email.getText().toString();
                if((!emailInserita.isEmpty())&& (emailInserita.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))){

                }else{
                    twCampoEmailVuoto.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}