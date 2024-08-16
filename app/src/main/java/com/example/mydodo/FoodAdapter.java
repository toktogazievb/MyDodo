package com.example.mydodo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mydodo.databinding.ItemFoodBinding;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private ArrayList<FoodModel> foodModels;
    private OnItemClick onItemClick;

    public FoodAdapter(ArrayList<FoodModel> foodModels, OnItemClick onItemClick) {
        this.foodModels = foodModels;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(foodModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodModels.size();
    }
}

class FoodViewHolder extends RecyclerView.ViewHolder {

    public ItemFoodBinding viewBinding;

    public FoodViewHolder(ItemFoodBinding viewBinding) {
        super(viewBinding.getRoot());
        this.viewBinding = viewBinding;
    }

    public void onBind(FoodModel foodModel) {
        viewBinding.tvPrice.setText(foodModel.getPrice());
        viewBinding.tvFood.setText(foodModel.getName());
        Glide.with(viewBinding.imgFood).load(foodModel.getImage()).into(viewBinding.imgFood);
    }
}
