package com.rajanapps.justjava;

import android.content.Intent;
import android.net.Uri;
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
    EditText nameET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameET = findViewById(R.id.name);
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
        if (quantity - 1 < 1) {
            Toast toast = Toast.makeText(this, "Really, At least one coffee!", Toast.LENGTH_LONG);
            toast.show();
            return;
        }
        quantity--;
        displayQuantity(quantity);
        displayPrice(calculatePrice());

    }

    private void displayPrice(int i) {
        TextView priceDisplay = findViewById(R.id.price_text_view);
        priceDisplay.setText(String.valueOf(i));
    }

    /**
     * increase quantity by 1 on clicking + button
     *
     * @param view decrease button.
     */
    public void increase(View view) {
        if (quantity + 1 > 100) {
            Toast.makeText(this, "Nah,It's too much!", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
        displayPrice(calculatePrice());
    }

    /**
     *
     * @return  whippedcream selection
     */
    private  boolean hasWhippedCream(){
        CheckBox whippedCream = findViewById(R.id.whipped_creamCB);
        return whippedCream.isChecked();

    }
    /**
     *
     */
    private boolean hasChocolate(){
        CheckBox chocolate = findViewById(R.id.chocolateCB);
       return chocolate.isChecked();
    }

    /**
     * create msg for order summary
     *
     * @return orser summary.
     */
    private String createOrdedrSummary() {
        //EditText nameET = findViewById(R.id.name);
        String orderDetails = "";
        orderDetails = "Name:: " + String.valueOf(nameET.getText());
        orderDetails += "\n Quantity:: " + quantity;
        if(hasWhippedCream()){
            orderDetails += "\n added Whipped Cream";
        }
        if(hasChocolate()){
            orderDetails += "\n added Chocolate";
        }

        orderDetails += "\n Total Price:: " + calculatePrice();
        return orderDetails +"\n Thank You!";
    }

    /**
     * called when Order button is clicked
     */
    public void submitOrder(View view) {
        //EditText nameET = findViewById(R.id.name);
        String orderSummary = createOrdedrSummary();
        //send an email intent.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"order summary for "+ String.valueOf(nameET.getText()));
        intent.putExtra(Intent.EXTRA_TEXT,orderSummary);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    /**
     * @return total price.
     */

    private int calculatePrice() {
        int basePrice = pricePerCoffee;
        int totalPrice;
        if(hasChocolate()){
            basePrice += 2;
        }
        if(hasWhippedCream()){
            basePrice += 1;
        }
        totalPrice = basePrice * quantity;
        return totalPrice;
    }

}
