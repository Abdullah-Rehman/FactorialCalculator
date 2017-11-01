package com.abdullah_rehman.factorialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;
import java.util.Locale;

public class Factorial extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    EditText etInput;
    TextView tvOutput;
    Button btnCalculate;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factorial);
        Log.d("Factorial App", "onCreate()");

        validator = new Validator(this);
        validator.setValidationListener(this);


        etInput = (EditText) findViewById(R.id.etInput);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

//        if(savedInstanceState!=null){
//            String value = savedInstanceState.getString("number");
//            etInput.setText(value);
//        }

        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                int num = Integer.parseInt(etInput.getText().toString());
//
//                tvOutput.setText(" " + factorial(num));
                validator.validate();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Factorial App", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Factorial App", "onResume()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
//        if(savedInstanceState!=null){
//            String value = savedInstanceState.getString("number");
//            etInput.setText(value);
//        }
        Log.d("Factorial App", "onRestoreInstanceState()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        if(!TextUtils.isEmpty(etInput.getText().toString())){
//            outState.putString("number", etInput.getText().toString());
//        }
        super.onSaveInstanceState(outState);
        Log.d("Factorial App", "onSaveInstanceState()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Factorial App", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Factorial App", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Factorial App", "onDestroy()");
    }

    private double factorial(double num) {

        if (num < 2) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    @Override
    public void onValidationSucceeded() {
        Toast.makeText(this, "Yay! we got it right!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        Toast.makeText(this, "Validation Failed", Toast.LENGTH_SHORT).show();
    }
}
