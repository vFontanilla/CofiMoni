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

import Common.Classes.GlobalVariables;

public class CategoriesActivity extends AppCompatActivity {

    // Declare UI elements
    private TextView dashboardTitle;
    private GridLayout gridLayout;
    private CardView catmenuCardView;
    private CardView catordersCardView1;
    private CardView catordersCardView2;
    private CardView catordersCardView3;
    private ImageView catImageView;
    private ImageView catordersImageView1;
    private ImageView catordersImageView2;
    private ImageView catordersImageView3;
    private TextView catmenuTextView;
    private TextView catordersTextView1;
    private TextView catordersTextView2;
    private TextView catordersTextView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize UI elements
        dashboardTitle = findViewById(R.id.dashboard);
        gridLayout = findViewById(R.id.gridLayout);

        catmenuCardView = findViewById(R.id.catmenuCardView);
        catordersCardView1 = findViewById(R.id.catordersCardView1);
        catordersCardView2 = findViewById(R.id.catordersCardView2);
        catordersCardView3 = findViewById(R.id.catordersCardView3);

        catImageView = findViewById(R.id.catImageView);
        catordersImageView1 = findViewById(R.id.catordersImageView1);
        catordersImageView2 = findViewById(R.id.catordersImageView2);
        catordersImageView3 = findViewById(R.id.catordersImageView3);

        catmenuTextView = findViewById(R.id.catmenuTextView);
        catordersTextView1 = findViewById(R.id.catordersTextView1);
        catordersTextView2 = findViewById(R.id.catordersTextView2);
        catordersTextView3 = findViewById(R.id.catordersTextView3);

        // Set up any additional logic or event listeners here
        catmenuCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisplayMenuActivity(GlobalVariables.CoffeeBase);
            }
        });

        catordersCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisplayMenuActivity(GlobalVariables.NoncoffeeBase);
            }
        });

        catordersCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisplayMenuActivity(GlobalVariables.Refreshments);
            }
        });

        catordersCardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisplayMenuActivity(GlobalVariables.Pastries);
            }
        });
    }

    private void openDisplayMenuActivity(String category) {
        Intent intent = new Intent(CategoriesActivity.this, DisplayMenuActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
