package com.example.buttoncounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;




public class MainActivity extends AppCompatActivity  {

    private Button buttonDecrease;
    private Button buttonIncrease;
    private Button buttonClear;
    private int currentValue;
    private TextView display;


    private String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.displayId);


        buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setBackgroundColor(Color.BLACK);
        buttonClear.setTextColor(Color.BLUE);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();

            }

        });

        buttonIncrease = findViewById(R.id.buttonIncrease);
        buttonIncrease.setBackgroundColor(Color.GREEN);
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incCount();

            }

        });
        buttonDecrease = findViewById(R.id.buttonDecrese);
        buttonDecrease.setBackgroundColor(Color.RED);
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decCount();

            }
        });



    }
    private void incCount(){

        currentValue = Integer.valueOf(display.getText().toString());
        currentValue++;
        display.setText(String.valueOf(currentValue));


    }

    private void decCount (){
        currentValue = Integer.valueOf(display.getText().toString());
        currentValue--;
        display.setText(String.valueOf(currentValue));

    }

    private void clearButton(){
        currentValue = Integer.valueOf(display.getText().toString());
        currentValue = 0;
        display.setText(String.valueOf(currentValue));


    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String counterValue = display.getText().toString();
        outState.putString("display", counterValue);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String counterValue = savedInstanceState.getString("display");
        display.setText(counterValue);
    }
}









