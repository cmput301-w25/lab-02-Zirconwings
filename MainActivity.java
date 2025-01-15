
/*
 * CMPUT 301
 *
 * Version Info
 *
 * 2025-01-15
 *
 * Copyright (c) 2025. Ugonna Akpulonu
 * All rights reserved
 */

package com.example.listycity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;
    Button addCity;
    Button deleteCity;
    Button confirmCity;
    EditText newCity;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        String []cities = {"Edmonton","Vancouver","Moscow","Sydney","Berlin","Vienna","Tokyo","Beijing","Osaka","New Delhi"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this,R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                city = parent.getItemAtPosition(position).toString();
            }
        });

    deleteCity = findViewById(R.id.delete_city);
    deleteCity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dataList.remove(city);
            cityAdapter.notifyDataSetChanged();
            System.out.println("Deleted " + city);
        }
    });

    addCity = findViewById(R.id.add_city);
    confirmCity = findViewById(R.id.confirm_city);
    newCity = findViewById(R.id.new_city);
    addCity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            confirmCity.setVisibility(View.VISIBLE);
            newCity.setVisibility(View.VISIBLE);
        }
    });
    confirmCity.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = newCity.getText().toString();
            if (!str.isBlank()){
                dataList.add(str);
                cityAdapter.notifyDataSetChanged();
                confirmCity.setVisibility(View.GONE);
                newCity.setVisibility(View.GONE);
            }
        }
    });

    }
}