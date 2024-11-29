package com.example.cofiproject;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ItemSelectedActivity  extends AppCompatActivity {

    private AutoCompleteTextView quantityInput;
    private AutoCompleteTextView quantityInput2;
    private String[] quantityOptions = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    private String[] sizeOptions = {"12 Oz", "16 Oz"};
    private TextView txtQuantity;
    private String itemName;
    private Double itemPrice;
    private TextView txtName;
    private TextView txtPrice;
    private TextView subtotalview;
    private Button btnAddToCart;
    private Button btnAddOrders;
    private Button btnAddCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_row_menu_selected);

        // Find the TextViews, Buttons, and EditText by their IDs
        txtQuantity = findViewById(R.id.txtQuantity);
        quantityInput = findViewById(R.id.quantityInput);
        quantityInput2 = findViewById(R.id.quantityInput2);
        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        subtotalview = findViewById(R.id.SubtotalPrice);
        btnAddToCart = findViewById(R.id.btnAddToCart);
        btnAddOrders = findViewById(R.id.btnAddOrders);
        btnAddCheckout = findViewById(R.id.btnAddCheckout);

        // Disable keyboard input for quantityInput
        quantityInput.setInputType(InputType.TYPE_NULL);
        quantityInput.setKeyListener(null);

        // Disable keyboard input for quantityInput2
        quantityInput2.setInputType(InputType.TYPE_NULL);
        quantityInput2.setKeyListener(null);

        // Set up the adapter for quantity input
        ArrayAdapter<String> quantityAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, quantityOptions);
        quantityInput.setAdapter(quantityAdapter);
        quantityInput.setThreshold(0);  // Show suggestions without typing

        // Show dropdown on focus
        quantityInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                quantityInput.showDropDown();
            }
        });

        // Show dropdown on click
        quantityInput.setOnClickListener(v -> quantityInput.showDropDown());

        // Set up the adapter for size input
        ArrayAdapter<String> sizeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, sizeOptions);
        quantityInput2.setAdapter(sizeAdapter);
        quantityInput2.setThreshold(0);  // Show suggestions without typing

        // Show dropdown on focus
        quantityInput2.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                quantityInput2.showDropDown();
            }
        });

        // Show dropdown on click
        quantityInput2.setOnClickListener(v -> quantityInput2.showDropDown());


        itemName = getIntent().getStringExtra("itemName");
        itemPrice = getIntent().getDoubleExtra("itemPrice",0.0);

        txtName.setText(itemName);
        txtPrice.setText(String.format("Price: PHP %.2f", itemPrice));

        // Add TextWatcher to quantityInput to update subtotal
        quantityInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateSubtotal();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        // Handle "Add to Cart" button click
        btnAddToCart.setOnClickListener(v -> {
            String quantityStr = quantityInput.getText().toString();
            String sizeStr = quantityInput2.getText().toString();
            if (quantityStr.isEmpty() || sizeStr.isEmpty()) {
                Toast.makeText(this, "Please select quantity and size.", Toast.LENGTH_SHORT).show();
            } else {
                int quantity = Integer.parseInt(quantityStr);
                double subtotal = quantity * itemPrice;
                // Add the item to the cart (you can implement the cart logic here)
                Toast.makeText(this, String.format("Added %s x%d to cart. Subtotal: PHP %.2f", itemName, quantity, subtotal), Toast.LENGTH_SHORT).show();
            }
        });

        // Handle "Add to Cart" button click
        btnAddOrders.setOnClickListener(v -> {
            String quantityStr = quantityInput.getText().toString();
            String sizeStr = quantityInput2.getText().toString();
            if (quantityStr.isEmpty() || sizeStr.isEmpty()) {
                Toast.makeText(this, "Please select quantity and size.", Toast.LENGTH_SHORT).show();
            } else {
                int quantity = Integer.parseInt(quantityStr);
                double subtotal = quantity * itemPrice;
                // Add the item to the cart (you can implement the cart logic here)
                Toast.makeText(this, "You clicked Add Items", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle "Add to Cart" button click
        btnAddCheckout.setOnClickListener(v -> {
            String quantityStr = quantityInput.getText().toString();
            String sizeStr = quantityInput2.getText().toString();
            if (quantityStr.isEmpty() || sizeStr.isEmpty()) {
                Toast.makeText(this, "Please select quantity and size.", Toast.LENGTH_SHORT).show();
            } else {
                int quantity = Integer.parseInt(quantityStr);
                double subtotal = quantity * itemPrice;
                // Add the item to the cart (you can implement the cart logic here)
                Toast.makeText(this, "You clicked Check Out", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateSubtotal() {
        String quantityStr = quantityInput.getText().toString();
        if (!quantityStr.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityStr);
                double subtotal = quantity * itemPrice;
                subtotalview.setText(String.format("Subtotal: PHP %.2f", subtotal));
            } catch (NumberFormatException e) {
                subtotalview.setText("Subtotal: PHP 0.00");
            }
        } else {
            subtotalview.setText("Subtotal: PHP 0.00");
        }
    }
}
