package com.example.mydodo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.mydodo.databinding.FragmentDetailScreenBinding;

import java.util.ArrayList;


public class DetailScreenFragment extends Fragment {

    private ArrayList<FoodModel> food = new ArrayList<>();
    FragmentDetailScreenBinding viewBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewBinding = FragmentDetailScreenBinding.inflate(getLayoutInflater());
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            FoodModel food = (FoodModel) getArguments().getSerializable("food");
            assert food != null;
            viewBinding.tvDesc.setText(food.getDescription());
            viewBinding.tvFood.setText(food.getName());
            viewBinding.tvPrice.setText(food.getPrice());
            Glide.with(viewBinding.imgFood).load(food.getImage()).into(viewBinding.imgFood);
        }
    }
}