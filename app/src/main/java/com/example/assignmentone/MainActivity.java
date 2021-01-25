package com.example.assignmentone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {


    private AutoCompleteTextView areaDropdown;
    private AutoCompleteTextView stateDropdown;
    private TextInputLayout birthday;
    private TextView birthdayText;
    private ArrayList<String> userData = new ArrayList<>();
    private Button submit;

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

        // Adding date Picker
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Select Your Date Of Birth");
        final MaterialDatePicker materialDatePicker = builder.build();

        // Making End Icon Clickable

        birthday = findViewById(R.id.birthday_field);
        birthday.setEndIconOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        // Setting value to text field
        birthdayText = findViewById(R.id.birthday_text);

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {

                //DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
                //Date date = new Date((Integer) selection);

                birthdayText.setText(materialDatePicker.getHeaderText());

            }
        });

        //Submit button saves all data as ArrayList ready for listView
        submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getInput();
                Intent i = new Intent(getApplicationContext(), InformationView.class);
                i.putStringArrayListExtra("data", userData);
                startActivity(i);
            }
        });
    }

    public ArrayList<String> getInput(){
        EditText nameText = findViewById(R.id.name_text);
        EditText phoneText = findViewById(R.id.phone_text);
        EditText addressText = findViewById(R.id.address_text);
        EditText cityText = findViewById(R.id.city_text);
        EditText zipText = findViewById(R.id.zip_text);
        EditText emailText = findViewById(R.id.email_text);

        String name = nameText.getText().toString();
        String phone = phoneText.getText().toString();
        String area = areaDropdown.getText().toString();
        String address = addressText.getText().toString();
        String city = cityText.getText().toString();
        String state = stateDropdown.getText().toString();
        String zip = zipText.getText().toString();
        String email = emailText.getText().toString();
        String birthday = birthdayText.getText().toString();

        userData.addAll(Arrays.asList(name, phone, area, address, city, state, zip, email, birthday));
        return userData;
    };
}