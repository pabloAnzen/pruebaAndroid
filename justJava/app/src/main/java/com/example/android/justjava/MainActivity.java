package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private TextView quantityTextView;
    private TextView orderSummaryTextView;
    private int quantity = 0;
    private static final double PRICE_PER_COFFE = 5;
    private double price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTextView    = (TextView) findViewById(R.id.quantity_text_view);
        orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);

    }

    private String createOrderSummary(){
        return new String(
                "Name: " + "Kaptain Kunal" + "\n" +
                "Quantity: " + quantity + "\n" +
                "Total: " + NumberFormat.getCurrencyInstance().format(price) + "\n" +
                "Thank you!" );
    }

    public void submitOrder(View view){
        calculatePrice();
        displayMessage(createOrderSummary());
    }

    private void calculatePrice(){
        price = quantity*PRICE_PER_COFFE;
    }

    private void displayQuantity(int number){
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message){
        orderSummaryTextView.setText(message);
    }

    public void increment(View view){
        quantity++;
        displayQuantity(quantity);
    }

    public  void decrement(View view){
        if (quantity > 1)
            quantity--;
        displayQuantity(quantity);
    }
}
