package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class cardetails extends AppCompatActivity {
    String CarName;
    String CarLogo;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardetails);
        Intent intent = getIntent();
        Toast toast= Toast.makeText(getApplicationContext(),"Your Car Can not Connect",Toast.LENGTH_SHORT);
        CarName = intent.getStringExtra("Car name");
        CarLogo = intent.getStringExtra("Car logo");
        ImageView carImageView = findViewById(R.id.carImageView);
        TextView carNameTextView = findViewById(R.id.carNameTextView);
        button = findViewById(R.id.button_id);

        carNameTextView.setText(CarName);
        Picasso.get().load(CarLogo).into(carImageView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call static method to display alert dialog
                toast.show();
            }
        });


    }


}