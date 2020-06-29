package com.covid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.covid19.R;
import com.covid19.responses.SummaryResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SummaryAdapter extends RecyclerView.Adapter<SummaryAdapter.SummaryHolder> {

    private Context context;
    private List<SummaryResponse.Country> data;
    public OnProductClick listener;

    public SummaryAdapter(Context context, List<SummaryResponse.Country> data) {
        this.context = context;
        this.data = data;
    }

    public void setListener(OnProductClick listener) {
        this.listener = listener;
    }

    public interface OnProductClick {
        void onDetails(String countryName);
    }

    public class SummaryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.countryName)
        TextView countryName;
        @BindView(R.id.casesNumber)
        TextView casesNumber;

        public SummaryHolder(@NonNull View itemView, OnProductClick listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDetails(data.get(getAdapterPosition()).getCountry());
                }
            });
        }
    }

    @NonNull
    @Override
    public SummaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.summary_item_list, parent, false);
        return new SummaryHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull SummaryHolder holder, int position) {
        SummaryResponse.Country country = data.get(position);

        holder.countryName.setText(country.getCountry());
        holder.casesNumber.setText(String.valueOf(country.getTotalConfirmed()));
    }

    @Override
    public int getItemCount() {
        return (data != null ? data.size() : 0);
    }
}
