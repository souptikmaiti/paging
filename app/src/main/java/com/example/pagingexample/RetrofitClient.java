package com.example.pagingexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {
    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    private static final String baseUrl = "https://api.stackexchange.com/2.2/";

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance==null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public JsonPlaceHolderApi getJsonPlaceHolderApi(){
        return retrofit.create(JsonPlaceHolderApi.class);
    }
}
