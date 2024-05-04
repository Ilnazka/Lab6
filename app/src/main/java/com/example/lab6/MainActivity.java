package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton1(View view) {
        startActivity(new Intent(this, ListActive.class));
    }

    public void onClickButton2(View view) {
        startActivity(new Intent(this, RR.class));
    }
//
    public void onClickButton3(View view) {
        startActivity(new Intent(this, RV.class));
    }
    public void onCLickButton4(View view) {
        startActivity(new Intent(this, Sight.class));
    }
}