package com.example.cofiproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import Common.Classes.DBHelper;
import Common.Classes.GlobalVariables;

public class ItemRegistrationActivity extends AppCompatActivity {

    private EditText editTextItemName;
    private EditText editTextItemPrice;
    private Button buttonRegister;
    private Button buttonBack;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        // Initialize UI elements
        editTextItemName = findViewById(R.id.editTextitmname);
        editTextItemPrice = findViewById(R.id.editTextitmprice);
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonBack = findViewById(R.id.buttonBack);

        dbHelper = new DBHelper(this);

        editTextItemName.addTextChangedListener(new TextWatcher() {
            private boolean isEditing = false;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                if (isEditing) {
                    return;
                }

                isEditing = true;

                // Get the current text
                String text = editable.toString();

                // If the text is not empty and the first character is not uppercase, make it uppercase
                if (!text.isEmpty() && !Character.isUpperCase(text.charAt(0))) {
                    editTextItemName.setText(text.substring(0, 1).toUpperCase() + text.substring(1));
                    editTextItemName.setSelection(editTextItemName.getText().length());
                }

                isEditing = false;
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegisterButtonClick();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void handleRegisterButtonClick() {
        // Get the category from the global variables
        String category = GlobalVariables.getInstance().getCategory();

        // Define a mapping between categories and their codes
        Map<String, String> categoryCodeMap = new HashMap<>();
        categoryCodeMap.put(GlobalVariables.CoffeeBase, "CB");
        categoryCodeMap.put(GlobalVariables.NoncoffeeBase, "NCB");
        categoryCodeMap.put(GlobalVariables.Refreshments, "R");
        categoryCodeMap.put(GlobalVariables.Pastries, "P");

        // Get the corresponding code for the current category
        String itemCode = categoryCodeMap.get(category);

        // Get text from EditText fields
        String itemName = editTextItemName.getText().toString().trim();
        String itemPriceString = editTextItemPrice.getText().toString().trim();

        // Validate input
        if (itemName.isEmpty() || itemPriceString.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Handle the registration logic based on category
        boolean result;
        switch (itemCode) {
            case "CB":
                result = dbHelper.insert_M_MENU_CB(itemCode, itemName, Double.parseDouble(itemPriceString));
                break;
            case "NCB":
                result = dbHelper.insert_M_MENU_CB(itemCode, itemName, Double.parseDouble(itemPriceString));
                break;
            case "R":
                result = dbHelper.insert_M_MENU_CB(itemCode, itemName, Double.parseDouble(itemPriceString));
                break;
            case "P":
                result = dbHelper.insert_M_MENU_CB(itemCode, itemName, Double.parseDouble(itemPriceString));
                break;
            default:
                Toast.makeText(this, "Invalid category code", Toast.LENGTH_SHORT).show();
                return;
        }

//        if (result) {
//            Toast.makeText(ItemRegistrationActivity.this, "Item registered successfully", Toast.LENGTH_SHORT).show();
//            clearInputFields();
//        } else {
//            Toast.makeText(ItemRegistrationActivity.this, "Failed to register item", Toast.LENGTH_SHORT).show();
//        }

        if (result) {
            Toast.makeText(ItemRegistrationActivity.this, "Item registered successfully", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK); // Set result to indicate success
            finish(); // Finish the activity and return to the previous one
        } else {
            Toast.makeText(ItemRegistrationActivity.this, "Failed to register item", Toast.LENGTH_SHORT).show();
            setResult(RESULT_CANCELED); // Set result to indicate failure
        }
    }

    private void clearInputFields() {
        // Clear input fields
        editTextItemName.setText("");
        editTextItemPrice.setText("");
    }
}
