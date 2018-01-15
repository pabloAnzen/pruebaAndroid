package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView quantityTextView;
    private TextView priceTextView;
    private int quantity = 0;
    private static final double PRICE_PER_COFFE = 5;
    private double price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView    = (TextView) findViewById(R.id.quantity_text_view);
        priceTextView       = (TextView) findViewById(R.id.price_text_view);

    }

    public void submitOrder(View view){
        price = (double) quantity * PRICE_PER_COFFE;
        displayMessage(price);
    }

    private void display(int number){
        quantityTextView.setText("" + number);
    }

    private void displayMessage(double price){
        priceTextView.setText("Total " + NumberFormat.getCurrencyInstance().format(price) + "\nThank You!");
    }

    public void increment(View view){
        quantity++;
        display(quantity);
    }

    public  void decrement(View view){
        if (quantity > 1)
            quantity--;
        display(quantity);
    }
}
