package com.covid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.covid19.R;
import com.covid19.responses.CasesByCountryResponse;
import com.covid19.util.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsHolder> {

    private Context context;
    private List<CasesByCountryResponse> data;

    public DetailsAdapter(Context context, List<CasesByCountryResponse> data) {
        this.context = context;
        this.data = data;
    }

    public class DetailsHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.date)
        TextView date;
        @BindView(R.id.casesNumber)
        TextView casesNumber;

        public DetailsHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public DetailsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_item_list, parent, false);
        return new DetailsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsHolder holder, int position) {
        CasesByCountryResponse country = data.get(position);

        holder.date.setText(Utils.editDate(country.getDate()));
        holder.casesNumber.setText(String.valueOf(country.getCases()));
    }

    @Override
    public int getItemCount() {
        return (data != null ? data.size() : 0);
    }
}
