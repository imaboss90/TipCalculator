package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("$#,##0.00");

    //https://www.youtube.com/watch?v=G03ZR0jKtVs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView totalTip = (TextView) findViewById(R.id.totalTipView);
        final EditText tipEditText = (EditText) findViewById(R.id.tipEditText);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final EditText billEditText = (EditText) findViewById(R.id.billEditText);
        final TextView totalBill = (TextView) findViewById(R.id.totalView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                
                tipEditText.setText(" " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                double bill = Double.parseDouble(billEditText.getText().toString());
                double tip = Double.parseDouble(tipEditText.getText().toString());

                double perc = seekBar.getProgress()/100;
                double sum = bill * perc;

                double total = bill + sum;

                totalTip.setText("" + df.format(sum));
                totalBill.setText("" + df.format(total));
            }
        });


    }

    public void calculate(View v){
        // Get references to all elements on app screen
        EditText billEditText = (EditText) findViewById(R.id.billEditText);
        EditText tipEditText = (EditText) findViewById(R.id.tipEditText);
        TextView totalTip = (TextView) findViewById(R.id.totalTipView);
        TextView totalBill = (TextView) findViewById(R.id.totalView);

        // get the values from the EditText boxes and convert them to double data types
        double bill = Double.parseDouble(billEditText.getText().toString());
        double tip = Double.parseDouble(tipEditText.getText().toString());

        // add the two double
        double perc = tip/100;
        double sum = bill * perc;

        double total = bill + sum;

        // set the text for the answer
        totalTip.setText("" + df.format(sum));
        totalBill.setText("" + df.format(total));

    }
}
