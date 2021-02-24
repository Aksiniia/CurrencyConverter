package com.example.currencyconverter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.R;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder> {


    private List<String> currencies;

    public CurrencyAdapter(List<String> currencies) {
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.currency_holder, parent, false);
        return new CurrencyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
        String c = currencies.get(position);
        holder.currencyName.setText(c);
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public class CurrencyHolder extends RecyclerView.ViewHolder {
        public TextView currencyName;
        public RadioButton currencyCheck;

        public CurrencyHolder(View view) {
            super(view);
            currencyName = view.findViewById(R.id.currencyName);
            currencyCheck = view.findViewById(R.id.currencyCheck);
        }
    }
}
