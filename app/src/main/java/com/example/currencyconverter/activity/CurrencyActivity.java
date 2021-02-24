package com.example.currencyconverter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.R;
import com.example.currencyconverter.adapter.CurrencyAdapter;
import com.example.currencyconverter.data.ConstData;

import java.util.ArrayList;
import java.util.List;

public class CurrencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        RecyclerView currencyList = findViewById(R.id.currencyList);
        currencyList.setLayoutManager(new LinearLayoutManager(this));
        currencyList.setAdapter(new CurrencyAdapter(this, ConstData.vals));

        findViewById(R.id.currencyBack).setOnClickListener(v -> finish());
    }
}
