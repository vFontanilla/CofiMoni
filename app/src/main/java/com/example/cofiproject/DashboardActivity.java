package com.example.cofiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    // Declare UI elements
    private TextView dashboardTitle;
    private GridLayout gridLayout;
    private CardView menuCardView;
    private CardView ordersCardView;
    private ImageView menuImageView;
    private ImageView ordersImageView;
    private TextView menuTextView;
    private TextView ordersTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize UI elements
        dashboardTitle = findViewById(R.id.dashboard);
        gridLayout = findViewById(R.id.gridLayout);

        menuCardView = findViewById(R.id.menuCardView);
        ordersCardView = findViewById(R.id.ordersCardView);

        menuImageView = findViewById(R.id.menuImageView);
        ordersImageView = findViewById(R.id.ordersImageView);

        menuTextView = findViewById(R.id.menuTextView);
        ordersTextView = findViewById(R.id.ordersTextView);

        // Set up any additional logic here
        menuCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Display Menu", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DashboardActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        ordersImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DashboardActivity.this, "Display Orders", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                startActivity(intent);
            }
        });
    }
}
