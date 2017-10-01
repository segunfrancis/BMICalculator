package com.example.android.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Main3Activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // get intent that started this activity
        Intent intent = getIntent();

        // get bundle that stores data of this activity
        Bundle bundle = intent.getExtras();

        // getting data from bundle
        String nameString = bundle.getString("name");
        Double bmiDouble = bundle.getDouble("bmi");
        DecimalFormat df = new DecimalFormat("#0.00");
        String bmiString = df.format(bmiDouble);

        // show data to layout
        TextView showName = (TextView)findViewById(R.id.result_page);
        showName.setText("Dear " + nameString);

        TextView showBMI = (TextView)findViewById(R.id.result_page2);
        showBMI.setText("Your BMI is " + bmiString);
    }
}