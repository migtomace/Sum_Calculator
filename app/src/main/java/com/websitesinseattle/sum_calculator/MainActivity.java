package com.websitesinseattle.sum_calculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String EXTRA_TEXT = "com.websitesinseattle.sum_calculator.EXTRA_TEXT";


    //define variable for the widgets
    private EditText numOne_editText;
    private EditText numTwo_editText;
    private Button button;
    private TextView sum_TextView;

    //define the shared pref object
    private SharedPreferences savedValues;

    //define variables to be saved
    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get reference to the widgets
        numOne_editText = findViewById(R.id.numOne_editText);
        numTwo_editText = findViewById(R.id.numTwo_editText);
        button = findViewById(R.id.button);


        //set the listener
        button.setOnClickListener(this);

        //get SharedPreferences object
        savedValues = getSharedPreferences("savedValues", MODE_PRIVATE);

    }

    public void calculateAndDisplay(){
        num1 = Integer.parseInt(numOne_editText.getText().toString());
        num2 = Integer.parseInt(numTwo_editText.getText().toString());

        int sum = num1 + num2;

        String nSum = sum + "";

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(EXTRA_TEXT, nSum);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        calculateAndDisplay();
    }
}
