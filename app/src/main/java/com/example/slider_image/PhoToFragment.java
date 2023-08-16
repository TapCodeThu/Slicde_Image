package com.example.slider_image;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PhoToFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo,container,false);
        Bundle bundle = getArguments();
        PhoTo phoTo = (PhoTo) bundle.get("object_photo");
        ImageView imageView = view.findViewById(R.id.imagePhoTo);
        imageView.setImageResource(phoTo.getResourceId());
        return view;
    }
}
