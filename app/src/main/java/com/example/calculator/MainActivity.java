package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView btnTap, imageViewCoin, imageView;
    private TextView count;
    private int counter = 0;
    private IDB database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        database = org.example.DataBase.getInstance();
        imageView = findViewById(R.id.gifimg);
        imageViewCoin = findViewById(R.id.coingif);
        btnTap = findViewById(R.id.gifimg);
        count = findViewById(R.id.textView);
        btnTap.setOnClickListener(this);
        count.setOnClickListener(this);
        findViewById(R.id.shopBtn).setOnClickListener(this);

        Glide.with(this)
                .asGif()
                .load(R.drawable.gifkatapalkaunscreen)
                .into(imageView);

        Glide.with(this)
                .asGif()
                .load(R.drawable.coin)
                .into(imageViewCoin);


    }

    private void incrementCounter() {
        counter++;
        count.setText(String.valueOf(counter));
        database.save(counter);
        System.out.println("database add " + counter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shopBtn:
                Intent intent = new Intent(MainActivity.this, Shop.class);
                startActivity(intent);
                break;
            case R.id.gifimg:
                incrementCounter();
                break;

        }
    }
}
