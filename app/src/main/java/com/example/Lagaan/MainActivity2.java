package com.example.Lagaan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Lagaan.databinding.ActivityMain2Binding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity implements MainClik {

    private ActivityMain2Binding binding;
    ArrayList<String> sublist = new ArrayList<>();
    ArrayList<String> sublist1 = new ArrayList<>();
    ArrayList<String> sublist2 = new ArrayList<>();
    SubCatAdapter subAdapter;
    Map<String, Object> map;
    Map<String, Object> mainMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        map = new HashMap<>();
        mainMap = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        sublist.add("a");

//        subAdapter = new SubCatAdapter(sublist, this);

        MainAdapter adapter = new MainAdapter(list, sublist,sublist1,sublist2, this, this, subAdapter);

        binding.recyclerview.setAdapter(adapter);

        binding.button3.setOnClickListener(v -> {
            list.add("b");
            mainMap.put(String.valueOf(list.size()), map);
            adapter.notifyDataSetChanged();
        });

    }

    @Override
    public void mainClick(int pos) {
        switch (pos){
            case 2: sublist2.add("a");
            break;
            case 1: sublist1.add("a");
            break;
            default: sublist.add("c");
        }
//        sublist.add("a");
//        subAdapter.notifyDataSetChanged();

    }
}