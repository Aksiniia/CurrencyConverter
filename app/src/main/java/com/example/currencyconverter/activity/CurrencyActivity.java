package com.example.currencyconverter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.currencyconverter.R;

import java.util.ArrayList;
import java.util.List;

public class CurrencyActivity extends AppCompatActivity {

    List<String> vals = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        vals.add("USD - Доллар США");
        vals.add("AUD - Австралийский доллар");
        vals.add("BYN - Белорусский рубль");
        vals.add("DKK - Датских крон");
        vals.add("EUR - Евро");
    }
}
