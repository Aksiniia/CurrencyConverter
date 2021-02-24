package com.example.currencyconverter.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.currencyconverter.R;
import com.example.currencyconverter.data.ConstData;
import com.example.currencyconverter.fragment.ConverterFragment;
import com.example.currencyconverter.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstData.vals.add("USD - Доллар США");
        ConstData.vals.add("AUD - Австралийский доллар");
        ConstData.vals.add("BYN - Белорусский рубль");
        ConstData.vals.add("DKK - Датских крон");
        ConstData.vals.add("EUR - Евро");

        BottomNavigationView mainBottomNav = findViewById(R.id.mainBottomNav);
        mainBottomNav.setOnNavigationItemSelectedListener(item -> {
            if (mainBottomNav.getSelectedItemId() == item.getItemId())
                return false;

            if (item.getItemId() == R.id.navClock) {
                changeFragment(new ConverterFragment());
            } else {
                changeFragment(new SettingsFragment());
            }

            return true;
        });

        changeFragment(new ConverterFragment());
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        changeFragment(new ConverterFragment());
    }
}