package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private String selection;
    private ArrayAdapter<String> adapter;

    private Button bttn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String numberOneEditText = findViewById(R.id.firstNumber).toString();
        String numberTwoEditText = findViewById(R.id.firstNumber).toString();
        bttn = findViewById(R.id.calculateButton);


        Spinner spinner = findViewById(R.id.dropDown);
        CreateSpinner(spinner); // abstraction




    }

    /**
     * This method is used to fill the spinner (dropdown) widget with elements using ArrayAdapter
     * SOURCE: CodeEasy on YouTube.com and ChatGPT for help understanding
     */
    public void CreateSpinner(Spinner s) {
        String[] elems = {"+", "-", "×","÷"};
        // An ArrayAdapter takes data from the code backend and displays it to UI elements
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elems);
        // Sets view to look in a specific layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
    public int calculate(Spinner s) {
        int numCalculated = 0;
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // An AdapterView is used to listed to the data from the ArrayAdapter
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = adapter.getItem(position); // gets selected item
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selection = adapter.getItem(0);
            }
        });
        return numCalculated;
    }
}