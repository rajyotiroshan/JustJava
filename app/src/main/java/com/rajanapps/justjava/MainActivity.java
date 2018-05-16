package com.rajanapps.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int pricePerCoffee = 5;
    private float basePrice =0;
    private String msg ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}

    /**
     * display the price
     *
     * @param number
     */
    private void displayQuantity(int number) {
        TextView quantityTV = findViewById(R.id.quantity_text_view);
        quantityTV.setText(number + "");
    }

    /**
     * decrease quantity by on clicking - button
     *
     * @param view
     */
    public void decrease(View view) {
        quantity--;
        displayQuantity(quantity);

    }

    /**
     * increase quantity by 1 on clicking + button
     *
     * @param view
     */
    public void increase(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * called when Order button is clicked
     */
    public void submitOrder(View view) {
        basePrice = quantity * pricePerCoffee;
        EditText nameET = (EditText)findViewById(R.id.name);
        msg = String.valueOf(nameET.getText());
        msg += "\nquantity: "+ quantity;
        msg += "\nprice: $" +basePrice;
        msg += "\nThank You";
        TextView priceTV = (TextView) findViewById(R.id.price_text_view);
        priceTV.setText(msg);
    }

}
