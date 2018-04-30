package com.rajanapps.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * called when Order button is clicked
     */
    void submitOrder(View view) {
        int noOfCofee = 2;
        display(noOfCofee);
        displayPrice(noOfCofee * 4);
    }

    /**
     * display the price
     *
     * @param number
     */
    private void display(int number) {
        TextView quantityTV = findViewById(R.id.quantity_text_view);
        quantityTV.setText(number);
    }


    /**
     * displays the price to the screen
     *
     * @param number total quantity
     */
    private void displayPrice(int number) {
        TextView priceTV = findViewById(R.id.price_text_view);
        priceTV.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    public void decrease(View view){
        int quantity = 1;
        display(quantity);
    }
    public void increase(View view){
        int quantity = 3;
        display(quantity);
    }
}
