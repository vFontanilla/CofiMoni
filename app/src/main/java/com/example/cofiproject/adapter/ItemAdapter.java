package com.example.cofiproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cofiproject.model.ItemModel;
import com.example.cofiproject.R;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    private List<ItemModel> itemList;
    private LayoutInflater inflater;

    public ItemAdapter(Context context, List<ItemModel> itemList) {
        this.itemList = itemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_menu, parent, false);
            holder = new ViewHolder();
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtPrice = convertView.findViewById(R.id.txtPrice);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ItemModel item = itemList.get(position);

        holder.txtName.setText(item.getName());
        holder.txtPrice.setText(String.format("Price: PHP %.2f", item.getPrice()));

        // Set alternating row colors
        if (position % 2 == 0) {
            convertView.setActivated(true);
        } else {
            convertView.setActivated(false);
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView txtName;
        TextView txtPrice; // Added for price display
    }
}
