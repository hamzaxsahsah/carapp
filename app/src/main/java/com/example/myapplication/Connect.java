package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Connect extends AppCompatActivity {
    ImageView imageButton1 ;
    ImageView imageButton2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        imageButton1 = findViewById(R.id.imageView);
        imageButton2 = findViewById(R.id.imageView2);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Connect.this,Cars.class);
                startActivity(i);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Connect.this,Cars.class);
                startActivity(i);
            }
        });
    }

}