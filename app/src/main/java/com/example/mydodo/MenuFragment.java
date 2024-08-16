package com.example.mydodo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mydodo.databinding.FragmentMenuBinding;

import java.util.ArrayList;


public class MenuFragment extends Fragment implements OnItemClick {

    private ArrayList<MenuModel> menu = new ArrayList<>();
    FragmentMenuBinding viewBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewBinding = FragmentMenuBinding.inflate(getLayoutInflater());
        return viewBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        MenuAdapter menuAdapter = new MenuAdapter(menu, this::onClick);
        viewBinding.rvMenu.setAdapter(menuAdapter);
    }

    private void loadData() {
        MenuModel pizzas = new MenuModel("https://www.eatingwell.com/thmb/k3RhYf4XhAeqAejYjdInOlSOp6I=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/gettyimages-1124303516-36413b5bf61f45f1b7d18d90000b56b7.jpg", "Пиццы");
        MenuModel drinks = new MenuModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCbW3kLacq54qGEKKCxW4ZFw6GYwSdfELfxw&s", "Напитки");
        MenuModel burgers = new MenuModel("https://assets.tmecosys.com/image/upload/t_web767x639/img/recipe/ras/Assets/102cf51c-9220-4278-8b63-2b9611ad275e/Derivates/3831dbe2-352e-4409-a2e2-fc87d11cab0a.jpg", "Бургеры");
        MenuModel sushi = new MenuModel("https://everydayglutenfreegourmet.ca/wp-content/uploads/2023/07/handmade-sushi-rolls.jpg", "Суши и роллы");

        menu.add(pizzas);
        menu.add(drinks);
        menu.add(burgers);
        menu.add(sushi);
    }


    @Override
    public void onClick(int position) {
        MenuModel menuModel = menu.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("type", menuModel);
        FoodFragment foodFragment = new FoodFragment();
        foodFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, foodFragment).addToBackStack(null).commit();
    }
}