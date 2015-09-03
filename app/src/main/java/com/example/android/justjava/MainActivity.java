package com.example.android.justjava;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    private int num_cups = 0;
    private double price_per_cup = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView totalCostTextView = (TextView) findViewById(R.id.total);
        totalCostTextView.setText(NumberFormat.getCurrencyInstance(Locale.CANADA).format(0.0));

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    //This method is called when the order button is clicked.

    public void order(View view) {
        EditText numCups = (EditText) findViewById(R.id.cups);
        if (numCups.length() != 0)
            num_cups = Integer.parseInt(numCups.getText().toString());

        EditText pricePerCup = (EditText) findViewById(R.id.cost);
        if (pricePerCup.length() != 0)
            price_per_cup = Double.parseDouble(pricePerCup.getText().toString());

        displayTotal(num_cups * price_per_cup);

        clicked(view);
    }

    public  void clicked(View view) {
        view.setBackgroundResource(R.drawable.back_checked);
    }

    public void clear(View view) {
        displayTotal(0.0);

        View order = findViewById(R.id.order);
        order.setBackgroundResource(R.drawable.back);
    }

    //This method displays the given quantity value on the screen.

    private void displayTotal(double total) {
        TextView totalCostTextView = (TextView) findViewById(R.id.total);
        totalCostTextView.setText(NumberFormat.getCurrencyInstance(Locale.CANADA).format(total));
    }

}