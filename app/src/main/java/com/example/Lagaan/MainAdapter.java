package com.example.Lagaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Papaya Coders on 08,July,2022
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ArrayList<String> list;
    private Context context;


    ArrayList<String> sublist;
    ArrayList<String> sublist1;
    ArrayList<String> sublist2;
    MainClik mainClik;
    SubCatAdapter adapter;


    public MainAdapter(ArrayList<String> list, ArrayList<String> sublist, ArrayList<String> sublist1, ArrayList<String> sublist2, Context context, MainClik mainClik, SubCatAdapter subAdapter) {
        this.sublist = sublist;
        this.sublist1 = sublist1;
        this.sublist2 = sublist2;
        this.list = list;
        this.context = context;
        this.mainClik = mainClik;
        this.adapter = subAdapter;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(
                LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        SubCatAdapter subAdapter;
        switch (position){
            case 2: subAdapter = new SubCatAdapter(sublist2, context);;
                break;
            case 1:  subAdapter = new SubCatAdapter(sublist1, context);
                break;
            default:  subAdapter = new SubCatAdapter(sublist, context);
        }


        holder.recyclerView.setAdapter(subAdapter);

        holder.button.setOnClickListener(v -> {
            mainClik.mainClick(position);
            subAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {


        Button button;
        RecyclerView recyclerView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button2);
            recyclerView = itemView.findViewById(R.id.cubcat);
        }
    }
}
