package com.abdullah_rehman.factorialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Factorial extends AppCompatActivity {

    EditText etInput;
    TextView tvOutput;
    Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);



        etInput = (EditText) findViewById(R.id.etInput);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        if(savedInstanceState!=null){
            String value = savedInstanceState.getString("number");
            etInput.setText(value);
        }

        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(etInput.getText().toString());

                tvOutput.setText(" " + factorial(num));
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null){
            String value = savedInstanceState.getString("number");
            etInput.setText(value);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(!TextUtils.isEmpty(etInput.getText().toString())){
            outState.putString("number", etInput.getText().toString());
        }
        super.onSaveInstanceState(outState);
    }

    private double factorial(double num) {

        if (num < 2) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
}
