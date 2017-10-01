package com.example.android.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Main2Activity extends AppCompatActivity {

    String name, weight, height;
    Double newWeight, newHeight, BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){

                EditText nameField = (EditText) findViewById(R.id.name);
                name = nameField.getText().toString();

                EditText weightField = (EditText) findViewById(R.id.weight);
                weight = weightField.getText().toString();

                EditText heightField = (EditText) findViewById(R.id.height);
                height = heightField.getText().toString();

                if(adapterView.getItemAtPosition(0) == "centimeters"){
                    newWeight = Double.parseDouble(weight);
                    newHeight = Double.parseDouble(height);
                    BMI = newWeight / ((newHeight * newHeight) / 100);
                }else if(adapterView.getItemAtPosition(1) == "meters"){
                    newWeight = Double.parseDouble(weight);
                    newHeight = Double.parseDouble(height);
                    BMI = newWeight / (newHeight * newHeight);
                }
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

    public void proceed(View view) {

        EditText nameField = (EditText) findViewById(R.id.name);
        name = nameField.getText().toString();

        EditText weightField = (EditText) findViewById(R.id.weight);
        weight = weightField.getText().toString();

        EditText heightField = (EditText) findViewById(R.id.height);
        height = heightField.getText().toString();

        if (name.isEmpty()|| name.equals(" ") || weight.equals("") || height.equals("")) {
            Toast.makeText(this, "Make sure all fields have been filled", Toast.LENGTH_SHORT).show();
        }else {

            // Creating Bundle Object
            Bundle bundle = new Bundle();

            // Storing Data into Bundle
            bundle.putString("name", name);
            bundle.putDouble("bmi", BMI);

            // Creating Intent Object
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);

            // Storing Bundle Object into Intent
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}