package com.example.calculatorproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String selection;
    private ArrayAdapter<String> adapter;

    private Button bttn;

    private double numCalculated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing all of my UI stuff
        EditText numberOneEditText = findViewById(R.id.firstNumber);
        EditText numberTwoEditText = findViewById(R.id.secondNumber);
        TextView resultView = findViewById(R.id.resultDisplay);
        bttn = findViewById(R.id.calculateButton);

        Spinner spinner = findViewById(R.id.dropDown);
        CreateSpinner(spinner);

        // Sets the button to listener and then has it perform calculations when clicked
        bttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberOneText = numberOneEditText.getText().toString();
                String numberTwoText = numberTwoEditText.getText().toString();

                try {
                    double numeroUno = Double.parseDouble(numberOneText); // live love spanish
                    double numeroDos = Double.parseDouble(numberTwoText);

                    // Get the selected operation from the spinner
                    selection = spinner.getSelectedItem().toString();

                    if (selection.equals("+")) {
                        numCalculated = numeroUno + numeroDos;
                    } else if (selection.equals("-")) {
                        numCalculated = numeroUno - numeroDos;
                    } else if (selection.equals("×")) {
                        numCalculated = numeroUno * numeroDos;
                    } else if (selection.equals("÷")) {
                        numCalculated = numeroUno / numeroDos;
                    }

                    // Display the result
                    String toDisplay = Double.toString(numCalculated);
                    resultView.setText(toDisplay);
                } catch (Exception e) {
                    // When input isn't valid
                    resultView.setText("Invalid input");
                }
            }
        });
    }

    /**
     * This method is used to fill the spinner (dropdown) widget with elements using ArrayAdapter
     * SOURCE: CodeEasy on Youtube
     */
    public void CreateSpinner(Spinner s) {
        String[] elems = {"+", "-", "×", "÷"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }
}
