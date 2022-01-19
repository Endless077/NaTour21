package com.example.schermateapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.schermateapp.HomePageActivity;
import com.example.schermateapp.R;

public class AssistenzaActivity extends AppCompatActivity {

    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistenza);

        backButton = (ImageButton) findViewById(R.id.imageButtonBack);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(AssistenzaActivity.this, HomePageActivity.class);
                //extra
                startActivity(newIntent);
            }
        });

    }
}