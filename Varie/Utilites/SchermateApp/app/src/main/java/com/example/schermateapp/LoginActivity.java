package com.example.schermateapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.schermateapp.ui.AssistenzaActivity;

import java.io.File;
import java.nio.file.Files;


//public enum WindowSizeClass{ COMPACT, MEDIUM, EXPANDED };

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


//        View decorView = getWindow().getDecorView();
//// Hide the status bar.
//        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
//// Remember that you should never show the action bar if the
//// status bar is hidden, so hide that too if necessary.
//        ActionBar actionBar = getActionBar();
//        actionBar.hide();

//        File fi = new File("../../../res/drawable/avatar.jpg");
//        BufferedImage originalImage=ImageIO.read(fnew);
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//        ImageIO.write(originalImage, "jpg", baos );
//        byte[] imageInByte=baos.toByteArray();

        TextView twPasswordDimenticatata = (TextView) findViewById(R.id.forgotPasswordTextView);
        TextView twRegistrati = (TextView) findViewById(R.id.textViewRegistrati);
        TextView twEmailErrata = (TextView) findViewById(R.id.textViewEmailErrata);
        TextView twPasswordErrata = (TextView) findViewById(R.id.textViewPasswordLoginErrata);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button loginFacebook = (Button) findViewById(R.id.loginFacebookButton);
        Button loginGoogle = (Button) findViewById(R.id.loginGoogleButton);
        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        ConstraintLayout cl = (ConstraintLayout) findViewById(R.id.ConstraintLayout);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = "";
                String password = "";
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                twEmailErrata.setVisibility(View.INVISIBLE);
                twPasswordErrata.setVisibility(View.INVISIBLE);
                boolean correct = true;


                if((email.isEmpty()) || (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))){
                    twEmailErrata.setVisibility(View.VISIBLE);
                    correct = false;
                }
                if((password.isEmpty())){
                    twPasswordErrata.setVisibility(View.VISIBLE);
                    correct = false;
                }

                if (correct) {
                    Intent newIntent = new Intent(LoginActivity.this, HomePageActivity.class);
                    startActivity(newIntent);
                }
            }
        });

        twPasswordDimenticatata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(LoginActivity.this, RecuperoPasswordActivity.class);
                startActivity(newIntent);
            }
        });

        loginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        twRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(LoginActivity.this, RegistrazioneActivity.class);
                startActivity(newIntent);
            }
        });

    }

}