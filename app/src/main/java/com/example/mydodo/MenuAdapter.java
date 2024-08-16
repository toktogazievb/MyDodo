package com.example.mydodo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mydodo.databinding.ItemMenuBinding;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    private ArrayList<MenuModel> menuModels;
    private OnItemClick onItemClick;

    public MenuAdapter(ArrayList<MenuModel> menuModels, OnItemClick onItemClick) {
        this.menuModels = menuModels;
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuViewHolder(ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.onBind(menuModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuModels.size();
    }
}

class MenuViewHolder extends RecyclerView.ViewHolder {

    public ItemMenuBinding viewBinding;

    public MenuViewHolder(ItemMenuBinding viewBinding) {
        super(viewBinding.getRoot());
        this.viewBinding = viewBinding;
    }

    public void onBind(MenuModel menuModel) {
        viewBinding.tvMenu.setText(menuModel.getName());
        Glide.with(viewBinding.imgMenu).load(menuModel.getImage()).into(viewBinding.imgMenu);
    }
}