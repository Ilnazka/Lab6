package com.example.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RR extends AppCompatActivity {

    ArrayList<State> states = new ArrayList<State>();
    ListView countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rr);

        // Начальная инициализация списка
        setInitialData();

        // Получаем элемент ListView
        countriesList = findViewById(R.id.countriesList);

        // Создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(this, R.layout.list_item, states);

        // Устанавливаем адаптер
        countriesList.setAdapter(stateAdapter);

        // Слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), ListActive.class);
                    startActivity(intent);
                }
                // Получаем выбранный пункт
                State selectedState = states.get(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();

            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }
    private static final int[] flagResourceIds = {
            R.drawable.flag_france, R.drawable.flag_ispan, R.drawable.flag_portugal,
            R.drawable.flag_nicaragua, R.drawable.flag_mongolia, R.drawable.flag_v
    };
    private void setInitialData() {
        // Получаем названия стран из массива ресурсов
        String[] countryNames = getResources().getStringArray(R.array.country_names);

        // Заполняем список состояний
        for (int i = 0; i < countryNames.length; i++) {
            // Проверяем, чтобы индекс массива флагов не выходил за пределы
            if (i < flagResourceIds.length) {
                // Создаем объект State и добавляем в список states
                states.add(new State(countryNames[i], "", flagResourceIds[i]));
            } else {
                // Если индекс превышает размер массива флагов, добавляем флаг по умолчанию или обрабатываем иначе
                states.add(new State(countryNames[i], "", R.drawable.def));
            }
        }
    }

//        states.add(new State ("Франция", "Париж", R.drawable.france));
//        states.add(new State ("Испания", "Мадрид", R.drawable.ispan));
//        states.add(new State ("Португалия", "Лиссабон", R.drawable.portugal));
//        states.add(new State ("Никарагуа", "Манагуа", R.drawable.nicaragua));
//        states.add(new State ("Монголия", "Улан-Батор", R.drawable.mongolia));
//        states.add(new State ("Великобритания", "Лондон", R.drawable.v));


//        states.add(new State ("Колумбия", "Богота", R.drawable.columbia));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uruguai));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.chile));

}
