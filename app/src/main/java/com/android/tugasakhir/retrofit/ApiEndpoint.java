package com.android.tugasakhir.retrofit;


import com.android.tugasakhir.FashionModel;
import com.android.tugasakhir.model.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET("result") Call<MainModel> getData();
    @GET("fashion")
    Call<FashionModel> getFashion();
}
