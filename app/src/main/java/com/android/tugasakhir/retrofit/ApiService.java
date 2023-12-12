package com.android.tugasakhir.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static String BASE_URL = "https://api.sheety.co/27ec2839a07893eb8e47ad897de2660d/restApi/";
    private static Retrofit retrofit = null;
    public static ApiEndpoint endpoint(){

        retrofit = new Retrofit.Builder()
                .baseUrl( BASE_URL )
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit.create( ApiEndpoint.class );
    }

}
