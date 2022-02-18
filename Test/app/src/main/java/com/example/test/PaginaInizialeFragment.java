package com.example.test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class PaginaInizialeFragment extends Fragment {

    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pagina_iniziale, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        imageView = getActivity().findViewById(R.id.imageViewFragment);
        Glide.with(getActivity())
                .load("https://art-of-lol.com/wp-content/uploads/2015/07/Jinx-League-Of-Legends-Wallpaper-HD-1920x1080-3.jpg")
                .centerCrop()
                .into(imageView);

    }
}