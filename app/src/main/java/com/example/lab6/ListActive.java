package com.example.lab6;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActive extends ListActivity {
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        String[] items = getResources().getStringArray(R.array.Nikaragua);
        ArrayAdapter Nikaruga = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        setListAdapter(Nikaruga);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent intent = new Intent(this, City.class);
        intent.putExtra("position", position);
        intent.putExtra("city", l.getItemAtPosition(position).toString());
        startActivity(intent);
    }
}
