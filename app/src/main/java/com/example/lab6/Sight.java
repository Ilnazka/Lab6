package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lab6.R;

public class Sight extends AppCompatActivity {
    ListView listView;
    Spinner spinner;
    String[] cities, sight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sight);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.lv);
        cities = getResources().getStringArray(R.array.Nikaragua);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Change(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void Change(int index) {
        switch (index) {
         case 0:sight = getResources().getStringArray(R.array.Манагуа); break;
            case 1: sight = getResources().getStringArray(R.array.Леон); break;
            case 2: sight = getResources().getStringArray(R.array.Чинандега); break;
            case 3: sight = getResources().getStringArray(R.array.Масая); break;
            case 4: sight = getResources().getStringArray(R.array.Эстели); break;
            case 5: sight = getResources().getStringArray(R.array.Типитапа); break;
            case 6: sight = getResources().getStringArray(R.array.Матагальпа); break;
            case 7: sight = getResources().getStringArray(R.array.Гранада); break;
            case 8: sight = getResources().getStringArray(R.array.Сьюдад_Сандино); break;
            case 9: sight = getResources().getStringArray(R.array.Хуигальпа); break;
    }


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sight);
        listView.setAdapter(arrayAdapter);
    }
}