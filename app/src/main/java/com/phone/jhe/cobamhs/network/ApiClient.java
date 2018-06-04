package com.phone.jhe.cobamhs.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.43.228/laravel/LaraSort/public/";
    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit(){
        if(mRetrofit==null){
            mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return mRetrofit;

    }
}
