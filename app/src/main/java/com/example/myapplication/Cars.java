package com.example.myapplication;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars extends AppCompatActivity {
    List<Car> filtreList  ;
    List<Car> carsListreplica ;


    ListView carsListView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cars);
        EditText searchView = findViewById(R.id.searchEditText);
        searchView.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {


                CustomAdapter adapter = new CustomAdapter(Cars.this, filter(s.toString()));
                carsListView.setAdapter(adapter);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });


        /*ImageView.OnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cars.this,cardetails.class);
                startActivity(intent);
            }
        });*/
        carsListView = findViewById(R.id.carsListView);
        List<String> carList = null;
        InputStream is = getResources().openRawResource(R.raw.cars);
        String jsonString ;
        Writer writer = new StringWriter();
        char[] buffer = new char[41000000];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        jsonString = writer.toString();
        Gson gson = new Gson();

// Deserialize the JSON string into an array of Car objects
        Car[] carsArray = gson.fromJson(jsonString, Car[].class);

// Alternatively, you can convert the array to a List if needed
        List<Car> carsList = Arrays.asList(carsArray);
        CustomAdapter adapter = new CustomAdapter(this, carsList);
        carsListView.setAdapter(adapter);
        filtreList = carsList ;
        carsListreplica = carsList ;

    }
    public List<Car> filter(String query) {
        List<Car> filteredCars ;
        if (query != ""){
             filteredCars = filtreList.stream()
                    .filter(car -> car.getName().toLowerCase().contains(query.toLowerCase()))
                    .collect(Collectors.toList());

        }
        else {
            filteredCars =filtreList ;

        }
        return filteredCars;
    }


}