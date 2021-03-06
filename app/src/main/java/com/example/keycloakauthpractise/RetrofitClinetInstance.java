package com.example.keycloakauthpractise;

import retrofit2.Retrofit;
import  retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClinetInstance {

    private static Retrofit retrofit;
    private static final String BASE_URL="http:/10.0.2.2:8080";

    public static Retrofit getRetrofitInstance(){

        //Checking if retrofit is null
        if(retrofit==null)
        {
            retrofit= new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }

}
