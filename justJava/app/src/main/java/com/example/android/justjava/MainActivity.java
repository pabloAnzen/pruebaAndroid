package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final double PRICE_PER_COFFE = 5.0;
    private static final double PRICE_PER_CREAM = 1.0;
    private static final double PRICE_PER_CHOCOLATE = 2.0;
    private static final int    MAX_NUMBER_COFFEES  = 100;
    private static final int    MIN_NUMBER_COFFEES  = 1;

    private EditText nameEditText;
    private TextView quantityTextView;
    private TextView orderSummaryTextView;
    private CheckBox creamCheckBox;
    private CheckBox chocolateCheckBox;
    private Boolean  creamIsChecked = Boolean.FALSE;
    private Boolean  chocolateIsChecked = Boolean.FALSE;
    private int      quantity = 1;
    private String   name;
    private double totalPrice = PRICE_PER_COFFE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView     = (TextView) findViewById(R.id.quantity_text_view);
        orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        creamCheckBox        = (CheckBox) findViewById(R.id.cream_checkbox);
        chocolateCheckBox    = (CheckBox) findViewById(R.id.chocolate_checkbox);
        nameEditText         = (EditText) findViewById(R.id.name_edit_text);

    }

    private String createOrderSummary(){

        return new String(
                 getString(R.string.name_colon,         name)                                           + "\n" +
                         getString(R.string.ask_whipped_cream,  creamIsChecked.toString())                      + "\n" +
                         getString(R.string.ask_chocolate,      chocolateIsChecked.toString())                  + "\n" +
                         getString(R.string.quantity_colon,     String.valueOf(quantity) )                      + "\n" +
                         getString(R.string.total_colon, NumberFormat.getCurrencyInstance().format(totalPrice)) + "\n" +
                         getString(R.string.thank_you) );
    }

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, name);
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary());
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void submitOrder(View view){

        creamIsChecked = creamCheckBox.isChecked();
        chocolateIsChecked = chocolateCheckBox.isChecked();
        name               = nameEditText.getText().toString();

        Log.v("MainActivity", "CkeckBox cream value: " + creamIsChecked);

        calculatePrice();
        //displayMessage(createOrderSummary());
        composeEmail();

    }

    private void calculatePrice(){

        double unitPrice = PRICE_PER_COFFE;
        if (creamIsChecked)
            unitPrice += PRICE_PER_CREAM;

        if (chocolateIsChecked)
            unitPrice += PRICE_PER_CHOCOLATE;

        totalPrice = quantity*unitPrice;
    }

    private void displayQuantity(int number){
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message){
        orderSummaryTextView.setText(message);
    }

    public void increment(View view){
        if (quantity < MAX_NUMBER_COFFEES) {
            quantity++;
            displayQuantity(quantity);
        } else{
            Toast mensaje = Toast.makeText( this, "Maximun quantity of cofshowfees is " + String.valueOf(MAX_NUMBER_COFFEES), Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }

    public  void decrement(View view){
        if (quantity > MIN_NUMBER_COFFEES){
            quantity--;
            displayQuantity(quantity);
        } else {
            Toast mensaje = Toast.makeText(this, "Minimum quantity of coffees is " + String.valueOf(MIN_NUMBER_COFFEES), Toast.LENGTH_SHORT);
            mensaje.show();
        }
    }
}
