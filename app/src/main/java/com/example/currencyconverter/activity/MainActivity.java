package com.example.currencyconverter.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.currencyconverter.R;
import com.example.currencyconverter.fragment.ConverterFragment;
import com.example.currencyconverter.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mainBottomNav = findViewById(R.id.mainBottomNav);
        mainBottomNav.setOnNavigationItemSelectedListener(item -> {
            if (mainBottomNav.getSelectedItemId() == item.getItemId())
                return false;

            switch (item.getItemId()) {
                case R.id.navClock: {
                    changeFragment(new ConverterFragment());

                    break;
                }

                default: {
                    changeFragment(new SettingsFragment());

                    break;
                }
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
}