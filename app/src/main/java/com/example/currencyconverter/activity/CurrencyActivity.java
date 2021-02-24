package com.example.currencyconverter.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.R;
import com.example.currencyconverter.adapter.CurrencyAdapter;

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

        RecyclerView currencyList = findViewById(R.id.currencyList);
        currencyList.setLayoutManager(new LinearLayoutManager(this));
        currencyList.setAdapter(new CurrencyAdapter(vals));
    }
}
