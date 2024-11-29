package com.example.cofiproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Common.Classes.DBHelper;
import Common.Classes.GlobalVariables;
import com.example.cofiproject.adapter.ItemAdapter;
import com.example.cofiproject.model.ItemModel;

public class DisplayMenuActivity extends AppCompatActivity {

    private ListView listView;
    private ItemAdapter itemAdapter;
    private List<ItemModel> itemList;
    private String category;
    private DBHelper dbHelper;
    Button addbuttonitem;
    private TextView userview;

    private static final int REQUEST_CODE_ITEM_REGISTRATION = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewmenu);

        dbHelper = new DBHelper(this);

        addbuttonitem = findViewById(R.id.addItemButton);
        listView = findViewById(R.id.listviewmenu);
        userview = findViewById(R.id.headerTextView);

        category = getIntent().getStringExtra("category");
        GlobalVariables.getInstance().setCategory(category);

        userview.setText(GlobalVariables.getInstance().getCategory());

        itemList = new ArrayList<>();
        itemAdapter = new ItemAdapter(this, itemList);
        listView.setAdapter(itemAdapter);

        refreshUI();

        addbuttonitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DisplayMenuActivity.this, ItemRegistrationActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ITEM_REGISTRATION);
            }
        });

        // Set an item click listener for the ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemModel selectedItem = itemList.get(position);
                Toast.makeText(DisplayMenuActivity.this, "Clicked: " + selectedItem.getName(), Toast.LENGTH_SHORT).show();
                // Perform other actions if needed, like starting a new activity
                 Intent intent = new Intent(DisplayMenuActivity.this, ItemSelectedActivity.class);
                 intent.putExtra("itemName", selectedItem.getName());
                intent.putExtra("itemPrice", selectedItem.getPrice());
                 startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ItemModel selectedItem = itemList.get(position);
                Toast.makeText(DisplayMenuActivity.this, "Clicked: " + selectedItem.getName(), Toast.LENGTH_SHORT).show();

                Cursor delete = dbHelper.EQuery("delete from M_MENU where MEN_ITEMNAME = '"+selectedItem.getName().trim()+"'");
                while (delete.moveToNext());
                Toast.makeText(DisplayMenuActivity.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                refreshUI();
                return true; // Return true to indicate the long click event was handled
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ITEM_REGISTRATION) {
            if (resultCode == RESULT_OK) {
                refreshUI();
            }
        }
    }

    private void refreshUI() {
        itemList.clear();
        if (GlobalVariables.CoffeeBase.equals(category)) {
            loadCoffeeBaseItems();
        } else if (GlobalVariables.NoncoffeeBase.equals(category)) {
            loadNonCoffeeBaseItems();
        } else if (GlobalVariables.Refreshments.equals(category)) {
            loadRefreshmentsItems();
        } else if (GlobalVariables.Pastries.equals(category)) {
            loadPastriesItems();
        } else {
            Toast.makeText(this, "Unknown Category", Toast.LENGTH_SHORT).show();
        }
    }

    private void loadCoffeeBaseItems() {
        Cursor cursor = dbHelper.EQuery("SELECT MEN_ITEMNAME, MEN_PRICE FROM M_MENU WHERE MEN_CODE = 'CB' ORDER BY MEN_ITEMNAME ASC");
        if (cursor != null) {
            try {
                itemList.clear();
                while (cursor.moveToNext()) {
                    String itemName = cursor.getString(0);
                    double itemPrice = cursor.getDouble(1);
                    itemList.add(new ItemModel(itemName, itemPrice));
                }
            } finally {
                cursor.close();
            }
            itemAdapter.notifyDataSetChanged();
        }
    }

    private void loadNonCoffeeBaseItems() {
        Cursor cursor = dbHelper.EQuery("SELECT MEN_ITEMNAME, MEN_PRICE FROM M_MENU WHERE MEN_CODE = 'NCB' ORDER BY MEN_ITEMNAME ASC");
        if (cursor != null) {
            try {
                itemList.clear();
                while (cursor.moveToNext()) {
                    String itemName = cursor.getString(0);
                    double itemPrice = cursor.getDouble(1);
                    itemList.add(new ItemModel(itemName, itemPrice));
                }
            } finally {
                cursor.close();
            }
            itemAdapter.notifyDataSetChanged();
        }
    }

    private void loadRefreshmentsItems() {
        Cursor cursor = dbHelper.EQuery("SELECT MEN_ITEMNAME, MEN_PRICE FROM M_MENU WHERE MEN_CODE = 'R' ORDER BY MEN_ITEMNAME ASC");
        if (cursor != null) {
            try {
                itemList.clear();
                while (cursor.moveToNext()) {
                    String itemName = cursor.getString(0);
                    double itemPrice = cursor.getDouble(1);
                    itemList.add(new ItemModel(itemName, itemPrice));
                }
            } finally {
                cursor.close();
            }
            itemAdapter.notifyDataSetChanged();
        }
    }

    private void loadPastriesItems() {
        Cursor cursor = dbHelper.EQuery("SELECT MEN_ITEMNAME, MEN_PRICE FROM M_MENU WHERE MEN_CODE = 'P' ORDER BY MEN_ITEMNAME ASC");
        if (cursor != null) {
            try {
                itemList.clear();
                while (cursor.moveToNext()) {
                    String itemName = cursor.getString(0);
                    double itemPrice = cursor.getDouble(1);
                    itemList.add(new ItemModel(itemName, itemPrice));
                }
            } finally {
                cursor.close();
            }
            itemAdapter.notifyDataSetChanged();
        }
    }
}
