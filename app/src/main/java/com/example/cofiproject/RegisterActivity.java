package com.example.cofiproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Common.Classes.DBHelper;

public class RegisterActivity extends AppCompatActivity {

    private DBHelper dbHelper;
    private EditText editTextUsername;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBHelper(this);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String M_USERNAME = editTextUsername.getText().toString().trim();
                String M_PASSWORD = editTextPassword.getText().toString().trim();

                if (M_USERNAME.isEmpty() || M_PASSWORD.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please enter both username and password", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean result = dbHelper.insert_USER_MASTER(M_USERNAME, M_PASSWORD, getCurrentDateTime());

                if (result) {
                    Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                    // Optionally, redirect to another activity or clear the input fields
                    clearInputFields();
                } else {
                    Toast.makeText(RegisterActivity.this, "Failed to register user", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getCurrentDateTime() {
        // Example: return current date and time in a specific format
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault());
        return sdf.format(new java.util.Date());
    }

    private void clearInputFields() {
        editTextUsername.setText("");
        editTextPassword.setText("");
    }
}
