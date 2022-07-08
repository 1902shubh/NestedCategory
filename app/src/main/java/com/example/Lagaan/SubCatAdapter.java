package com.example.Lagaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Papaya Coders on 08,July,2022
 */
public class SubCatAdapter  extends RecyclerView.Adapter<SubCatAdapter.SubCatViewHolder> {

    private ArrayList<String> list;
    private Context context;

    public SubCatAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public SubCatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SubCatViewHolder(
                LayoutInflater.from(context).inflate(R.layout.sub_cat_layout, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SubCatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SubCatViewHolder extends RecyclerView.ViewHolder {

        public SubCatViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
