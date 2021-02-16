package com.example.currencyconverter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.currencyconverter.R;
import com.example.currencyconverter.fragment.ConverterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, new ConverterFragment())
                .commit();
    }
}