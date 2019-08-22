package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View v){
        // Get references to all elements on app screen
        EditText billEditText = (EditText) findViewById(R.id.billEditText);
        EditText tipEditText = (EditText) findViewById(R.id.tipEditText);
        TextView finalBillView = (TextView) findViewById(R.id.finalBillView);

        // get the values from the EditText boxes and convert them to int data types
        int bill = Integer.parseInt(billEditText.getText().toString());
        int tip = Integer.parseInt(tipEditText.getText().toString());

        // add the two ints
        int perc = tip/100;
        int sum = bill * perc;
        int coconut = 0;

        // set the text for the answer
        finalBillView.setText(""+sum);
    }
}
