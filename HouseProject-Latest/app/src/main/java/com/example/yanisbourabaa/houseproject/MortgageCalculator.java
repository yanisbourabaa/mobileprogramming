package com.example.yanisbourabaa.houseproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;


public class MortgageCalculator extends AppCompatActivity {
    EditText mortgageAmount, interestRate, monthlyCost, totalCost;
    Spinner yearSpinner;
    Button calcButton;
    double amountDouble = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        setTitle("Mortgage Calculator");


        Intent intent = getIntent();
        amountDouble = intent.getDoubleExtra("HousePrice", 0);

        mortgageAmount = (EditText) findViewById(R.id.m_amount);
        interestRate = (EditText) findViewById(R.id.m_interestRate);
        monthlyCost = (EditText) findViewById(R.id.monthly_cost);
        totalCost = (EditText) findViewById(R.id.total_cost);

        yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        calcButton = (Button) findViewById(R.id.calc_button);

        mortgageAmount.setText("$ " + NumberFormat.getNumberInstance(Locale.US).format(amountDouble));
        mortgageAmount.setFocusable(false);

        monthlyCost.setFocusable(false);
        totalCost.setFocusable(false);
    }

    public void calculate (View view) {
        int selectedYears = Integer.valueOf(String.valueOf(yearSpinner.getSelectedItem()));
        double rate = 0;

        if (!mortgageAmount.getText().toString().equals("") && !interestRate.getText().toString().equals("")) {
            rate = Double.parseDouble(interestRate.getText().toString());
            rate /= 100;

            //M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1]
            double i = (rate / 12);
            int n = selectedYears * 12;

            double monthlyCostValue = 0;
            double totalCostValue = 0;

            totalCostValue = (amountDouble * (i * Math.pow(1 + i, n))) / (Math.pow(1 + i, n) - 1) * n;
            monthlyCostValue = (totalCostValue / n);

            String totalCostString = String.format("%.2f", totalCostValue);
            String monthlyCostString = String.format("%.2f", monthlyCostValue);

            totalCostString = NumberFormat.getNumberInstance(Locale.US).format(Double.parseDouble(totalCostString));
            monthlyCostString = NumberFormat.getNumberInstance(Locale.US).format(Double.parseDouble(monthlyCostString));

            monthlyCost.setText("$ " + monthlyCostString);
            totalCost.setText("$ " + totalCostString);


        } else {
            Toast.makeText(MortgageCalculator.this, "Fields cannot be empty", Toast.LENGTH_LONG).show();
        }
    }
}