package com.example.assignmentone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {


    private AutoCompleteTextView areaDropdown;
    private AutoCompleteTextView stateDropdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Area Dropdown Adapter & List information
        areaDropdown = findViewById(R.id.area_dropdown);
        List<String> areas = new ArrayList<>(Arrays.asList("+44", "+33", "+49", "+34", "+351", "+41" ));

        ArrayAdapter<String> areaAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                areas
        );

        areaDropdown.setAdapter(areaAdapter);

        // State Dropdown & List Information
        stateDropdown = findViewById(R.id.state_dropdown);
        List<String> states = new ArrayList<>(Arrays.asList("UK", "France", "Germany", "Spain", "Portugal", "Switzerland"));

        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_spinner_item,
                states
        );
        stateDropdown.setAdapter(stateAdapter);




    }
}