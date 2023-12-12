package com.android.tugasakhir;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    TextView textView;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = findViewById(R.id.toolbar); //Ignore red line errors
        textView = findViewById(R.id.textdetail);

        setSupportActionBar(toolbar);
        String title = getIntent().getStringExtra("intent_title");
        String image = getIntent().getStringExtra("intent_image");
        String deskripsi = getIntent().getStringExtra("deskripsi");
        String maps = getIntent().getStringExtra("url_map");

        textView.setText(deskripsi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle( title );
        mImageView = (ImageView) findViewById(R.id.imageView);
        Glide.with(this)
                .load( image )
                .placeholder(R.drawable.img_placeholder)
                .into(mImageView);

        Button openUrlButton = findViewById(R.id.buttonmaps);
        openUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = maps;

                // Buat Intent untuk membuka browser dengan URL yang ditentukan
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                // Periksa apakah ada aplikasi browser yang dapat menangani intent ini
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

    public void maps(View view) {

    }
}
