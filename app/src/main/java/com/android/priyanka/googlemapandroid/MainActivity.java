package com.android.priyanka.googlemapandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar  = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);


        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);

           btn1.setOnClickListener(this);
           btn2.setOnClickListener(this);
           btn3.setOnClickListener(this);
           btn4.setOnClickListener(this);
           btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn1:
                Intent i = new Intent(MainActivity.this,MapsActivity.class);
                startActivity(i);
                break;
            case R.id.btn2:
                Intent i2 = new Intent(MainActivity.this,MapsActivity2.class);
                startActivity(i2);
                break;
            case R.id.btn3:
                Intent i3 = new Intent(MainActivity.this,MapsActivity3.class);
                startActivity(i3);
                break;
            case R.id.btn4:
                Intent i4 = new Intent(MainActivity.this,MapsActivity4.class);
                startActivity(i4);
                break;
            case R.id.btn5:
                Intent i5 = new Intent(MainActivity.this,MapsActivity5.class);
                startActivity(i5);
                break;
        }


    }
}
