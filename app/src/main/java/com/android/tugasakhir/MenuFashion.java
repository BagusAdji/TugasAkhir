package com.android.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.tugasakhir.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuFashion extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FashionAdapter mainAdapter;
    private ArrayList<FashionModel.Result> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_fashion);

        Toolbar toolbar = findViewById(R.id.toolbarmenu);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle( "Menu Fashion" );
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupView();
        setupRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showLoading(false);
        getDataFromApi();
    }

    private void setupView () {
        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
    }

    private void setupRecyclerView (){
        mainAdapter = new FashionAdapter(this, results, new FashionAdapter.AdapterListener() {
            @Override
            public void onClick(FashionModel.Result result) {
                Intent intent = new Intent(MenuFashion.this, DetailActivity.class);
                intent.putExtra("intent_title", result.getTitle());
                intent.putExtra("intent_image", result.getImage());
                intent.putExtra("deskripsi", result.getDescription());
                startActivity( intent );
            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager( layoutManager );
        recyclerView.setAdapter( mainAdapter );
    }

    private void getDataFromApi() {
        showLoading( true );
        ApiService.endpoint().getFashion()
                .enqueue(new Callback<FashionModel>() {
                    @Override
                    public void onResponse(Call<FashionModel> call, Response<FashionModel> response) {
                        showLoading( false );
                        Log.d( TAG, "onResponse: " + response.toString());
                        if (response.isSuccessful()) {
                            List<FashionModel.Result> results = response.body().getFashion();
                            Log.d(TAG, results.toString());
                            mainAdapter.setData( results );
                        }
                    }
                    @Override
                    public void onFailure(Call<FashionModel> call, Throwable t) {
                        showLoading( false );
                        Log.d( TAG, t.toString());
                    }
                });
    }

    private void showLoading(Boolean loading) {
        if (loading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}