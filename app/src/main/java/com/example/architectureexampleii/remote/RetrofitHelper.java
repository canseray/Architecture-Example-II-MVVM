package com.example.architectureexampleii.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static final String BASE_URL="http://localhost/android/categories.php/";

    private static Retrofit getRetrofitInstance(){

        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
    }

    public static APIService getAPIService(){



        return getRetrofitInstance().create(APIService.class);
    }
}
