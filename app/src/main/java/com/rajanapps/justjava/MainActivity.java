package com.rajanapps.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int pricePerCoffee = 5;
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
        quantityTV.setText(String.valueOf(number));
    }

    /**
     * decrease quantity by on clicking - button
     *
     * @param view decrease button
     */
    public void decrease(View view) {
        if(quantity-1 < 1){
            Toast toast = Toast.makeText(this,"Really, At least one coffee!",Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        quantity--;
        displayQuantity(quantity);

    }

    /**
     * increase quantity by 1 on clicking + button
     *
     * @param view decrease button.
     */
    public void increase(View view) {
        if(quantity + 1 >100){
            Toast.makeText(this , "Nah,It's too much!", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * called when Order button is clicked
     */
    public void submitOrder(View view) {
        int totalPrice = 0;
        int basePrice = 0;
        //price of coffee + any toppings.
        basePrice = pricePerCoffee;
        totalPrice = basePrice * quantity;
        EditText nameET = (EditText)findViewById(R.id.name);
        msg = String.valueOf(nameET.getText());
        msg += "\nquantity: "+ quantity;
        msg += "\nprice: $" +totalPrice;
        msg += "\nThank You";
        TextView priceTV = (TextView) findViewById(R.id.price_text_view);
        priceTV.setText(msg);
    }

}
