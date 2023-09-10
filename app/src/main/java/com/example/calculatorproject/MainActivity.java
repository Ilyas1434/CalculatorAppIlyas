package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.dropDown);
        CreateSpinner(spinner);


    }
    // The below block of code fills the dropdown menu, and sets its specific type
    //SOURCE: CodeEasy on YouTube and some help explaining with ChatGPT

    /**
     * This method is used to fill the spinner (dropdown) widget with elements using ArrayAdapter
     * SOURCE: CodeEasy on YouTube.com and ChatGPT for help understanding
     */
    public void CreateSpinner(Spinner s) {
        String[] elems = {"+", "-", "×","÷"};
        // An ArrayAdapter takes data from the code backend and displays it to UI elements
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elems);
        // Sets view to look in a specific layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}