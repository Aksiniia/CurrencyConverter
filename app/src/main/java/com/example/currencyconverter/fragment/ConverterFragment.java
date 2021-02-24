package com.example.currencyconverter.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.currencyconverter.R;
import com.example.currencyconverter.activity.CurrencyActivity;
import com.example.currencyconverter.activity.MainActivity;
import com.example.currencyconverter.data.ConstData;
import com.example.currencyconverter.data.UserData;
import com.example.currencyconverter.model.TestModel;

import java.util.Locale;

import retrofit2.Callback;

public class ConverterFragment extends Fragment {

    private final double CURRENT_CURRENCY = 13.4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_converter, container, false);

        TextView currencyResult = view.findViewById(R.id.currencyResult);

        ((TextView) view.findViewById(R.id.currencyName)).setText(ConstData.vals.get(UserData.currentVal));

        ((TextView) view.findViewById(R.id.currencyValue)).setText(
                String.format(
                        Locale.getDefault(),
                        "1 %s - %.2f RUB",
                        ConstData.vals.get(UserData.currentVal).substring(0, 3),
                        CURRENT_CURRENCY
                )
        );

        ((EditText) view.findViewById(R.id.converterInput)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0)
                    currencyResult.setText(
                            String.format(
                                    Locale.getDefault(),
                                    "%.2f",
                                    Integer.parseInt(s.toString()) / CURRENT_CURRENCY
                            )
                    );

                else
                    currencyResult.setText("0");
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        view.findViewById(R.id.currencyChange).setOnClickListener(v ->
                startActivity(
                        new Intent(
                                container.getContext(),
                                CurrencyActivity.class
                        )
                )
        );

        return view;
    }
}

