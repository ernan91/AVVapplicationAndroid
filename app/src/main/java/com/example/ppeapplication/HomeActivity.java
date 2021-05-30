package com.example.ppeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ppeapplication.models.User;

public class HomeActivity extends AppCompatActivity {
    private Button  VoirActivite;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        VoirActivite = findViewById(R.id.button_voiractivite);
        user = (User) getIntent().getSerializableExtra("KEY");
       VoirActivite.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ActiviteActivity.class);
                startActivity(intent);
            }
        });
    }

}