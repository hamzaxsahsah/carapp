package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Car;
import com.example.myapplication.R;
import com.squareup.picasso.Picasso; // You may need to add Picasso library to your dependencies

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Car> {
    private Context context;
    private List<Car> dataList;

    public CustomAdapter(Context context, List<Car> dataList) {
        super(context, 0, dataList);
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.car, parent, false);
        }

        Car currentItem = dataList.get(position);

        ImageView carImageView = listItemView.findViewById(R.id.carImageView);
        TextView carNameTextView = listItemView.findViewById(R.id.carNameTextView);


        carNameTextView.setText(currentItem.getName());

        Picasso.get().load(currentItem.getImage().getOriginal()).into(carImageView); // Use Picasso to load the image*/
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomAdapter.this.getContext(),cardetails.class);
                intent.putExtra("Car name" ,currentItem.getName() );
                intent.putExtra("Car logo" ,currentItem.getImage().getOriginal() );
                context.startActivity(intent);

            }
        });
        return listItemView;
    }
}
