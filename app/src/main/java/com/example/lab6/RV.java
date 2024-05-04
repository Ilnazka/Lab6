package com.example.lab6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RV extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<>();
    RecyclerView countriesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

        // Начальная инициализация списка
        setInitialData();

        // Получаем элемент RecyclerView
        countriesRecyclerView = findViewById(R.id.countriesRecyclerView);

        // Создаем и устанавливаем LayoutManager для RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        countriesRecyclerView.setLayoutManager(layoutManager);

        // Создаем адаптер
        StateAdapter stateAdapter = new StateAdapter(states);
        countriesRecyclerView.setAdapter(stateAdapter);

        // Слушатель выбора в списке
        stateAdapter.setOnItemClickListener(new StateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), ListActive.class);
                    startActivity(intent);
                }
                // Получаем выбранный пункт
                State selectedState = states.get(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
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

    static class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

        private ArrayList<State> mStates;
        private OnItemClickListener mListener;

        public StateAdapter(ArrayList<State> states) {
            mStates = states;
        }

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            mListener = listener;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view, mListener);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            State state = mStates.get(position);
            holder.countryNameTextView.setText(state.getName());
            holder.flagImageView.setImageResource(state.getFlagResourceId());
        }

        @Override
        public int getItemCount() {
            return mStates.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {

            ImageView flagImageView;
            TextView countryNameTextView;

            public ViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
                super(itemView);
                flagImageView = itemView.findViewById(R.id.flag);
                countryNameTextView = itemView.findViewById(R.id.name);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onItemClick(view, position);
                            }
                        }
                    }
                });
            }
        }
    }

    static class State {
        private String name;
        private String capital;
        private int flagResourceId;

        public State(String name, String capital, int flagResourceId) {
            this.name = name;
            this.capital = capital;
            this.flagResourceId = flagResourceId;
        }

        public String getName() {
            return name;
        }

        public String getCapital() {
            return capital;
        }

        public int getFlagResourceId() {
            return flagResourceId;
        }
    }
}