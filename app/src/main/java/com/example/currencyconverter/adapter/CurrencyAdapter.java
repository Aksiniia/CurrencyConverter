package com.example.currencyconverter.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyconverter.R;
import com.example.currencyconverter.data.UserData;

import java.util.List;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder> {

    private final Activity activity;
    private final List<String> currencies;

    public CurrencyAdapter(Activity activity, List<String> currencies) {
        this.activity = activity;
        this.currencies = currencies;
    }

    @NonNull
    @Override
    public CurrencyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return
                new CurrencyHolder(
                        LayoutInflater
                                .from(parent.getContext())
                                .inflate(R.layout.currency_card, parent, false)
                );
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyHolder holder, int position) {
        if (UserData.currentVal == position)
            holder.currencyDot.setVisibility(View.VISIBLE);
        else
            holder.currencyDot.setVisibility(View.GONE);

        String c = currencies.get(position);
        ((TextView) holder.itemView.findViewById(R.id.currencyName)).setText(c);

        holder.itemView.setOnClickListener(v -> {
            UserData.currentVal = position;

            activity.finish();
        });
    }

    @Override
    public int getItemCount() {
        return currencies.size();
    }

    public static class CurrencyHolder extends RecyclerView.ViewHolder {
        public ImageView currencyDot;

        public CurrencyHolder(View view) {
            super(view);

            currencyDot = view.findViewById(R.id.currencyDot);
        }
    }
}
