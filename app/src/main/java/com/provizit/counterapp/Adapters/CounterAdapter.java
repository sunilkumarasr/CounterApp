package com.provizit.counterapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.provizit.counterapp.Models.CompanyData;
import com.provizit.counterapp.R;
import java.util.ArrayList;

public class CounterAdapter extends RecyclerView.Adapter<CounterAdapter.MyviewHolder> {
    Context context;
    ArrayList<CompanyData> counterList;
    private OnItemClickListener onItemClickListener;

    public CounterAdapter(Context mContext, ArrayList<CompanyData> counterList, OnItemClickListener listener) {
        this.context = mContext;
        this.counterList = counterList;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.counter_items_list, parent, false);
        return new MyviewHolder(itemView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, @SuppressLint("RecyclerView") final int position) {
        CompanyData item = counterList.get(position);

        holder.txtName.setText(item.getName());

        // Set the click listener for each item
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(item);
            }
        });

    }

    @Override
    public int getItemCount() {
        return counterList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView txtName;

        public MyviewHolder(View view) {
            super(view);
            txtName = view.findViewById(R.id.txtName);
        }
    }


    // Interface to handle item click
    public interface OnItemClickListener {
        void onItemClick(CompanyData counterItem);
    }

}
