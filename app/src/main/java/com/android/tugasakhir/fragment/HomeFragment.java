package com.android.tugasakhir.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.android.tugasakhir.MenuFashion;
import com.android.tugasakhir.MenuMakanan;
import com.android.tugasakhir.R;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageSlider imageSlider = view.findViewById(R.id.ImageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.image1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.image5, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        LinearLayout btnmenu = view.findViewById(R.id.menumakanan);
        LinearLayout btnfashion = view.findViewById(R.id.menufashion);
        LinearLayout btnkerajinan = view.findViewById(R.id.btn_kerajinan);
        LinearLayout btnjasa = view.findViewById(R.id.btn_jasa);

        // Menambahkan OnClickListener ke LinearLayout
       btnmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuMakanan.class);
                startActivity(intent);
            }
        });

        btnfashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuFashion.class);
                startActivity(intent);
            }
        });

        btnkerajinan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membangun alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Informasi");
                builder.setMessage("Fitur sedang maintance (Developer Malas Berat).");

                // Menambahkan tombol positif (OK)
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Kode yang akan dijalankan saat tombol OK diklik
                        dialog.dismiss(); // Menutup dialog
                    }
                });

                // Menampilkan alert dialog
                builder.show();
            }
        });
        btnjasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membangun alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Informasi");
                builder.setMessage("Fitur sedang maintance (Developer Malas Berat).");

                // Menambahkan tombol positif (OK)
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Kode yang akan dijalankan saat tombol OK diklik
                        dialog.dismiss(); // Menutup dialog
                    }
                });

                // Menampilkan alert dialog
                builder.show();
            }
        });

        return view;
    }



}