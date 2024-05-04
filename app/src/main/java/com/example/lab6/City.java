package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class City extends AppCompatActivity {
    TextView tv1, tv2;
    ImageView flagImageView;
    String text;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        tv1 = findViewById(R.id.city);
        tv2 = findViewById(R.id.opisanie);
        flagImageView = findViewById(R.id.flag);
        getInfo();

    }

    public void getInfo() {

        Intent intent = getIntent();
        String name = intent.getStringExtra("city");
        int i = intent.getIntExtra("position", 0);

        switch (i) {
            case 0:
                text = getString(R.string.Манагуа);
                break;
            case 1:
                text = getString(R.string.Леон);
                break;
            case 2:
                text = getString(R.string.Чинандега);
                break;
            case 3:
                text = getString(R.string.Масая);
                break;
            case 4:
                text = getString(R.string.Эстели);
                break;
            case 5:
                text = getString(R.string.Типитапа);
                break;
            case 6:
                text = getString(R.string.Матагальпа);
                break;
            case 7:
                text = getString(R.string.Гранада);
                break;
            case 8:
                text = getString(R.string.Сьюдад_Сандино);
                break;
            case 9:
                text = getString(R.string.Хуигальпа);
                break;
        }
        tv1.setText(name);
        tv2.setText(text);

        // Установка изображения флага
        int flagResourceId = R.drawable.flag_nicaragua;
        flagImageView.setImageResource(flagResourceId);
    }

//    // Метод для получения ресурса изображения флага на основе позиции города
//    private int getFlagResourceId(int position) {
//        switch (position) {
//            case 0:
//                return R.drawable.brazile; // Предположим, что у вас есть изображение флага для Манагуа
//            case 1:
//                return R.drawable.images; // Предположим, что у вас есть изображение флага для Леона
//             //Добавьте остальные кейсы для остальных городов
//            default:
//                return R.drawable.brazile; // Возвращаем стандартный флаг, если позиция неизвестна
//        }
//    }

}