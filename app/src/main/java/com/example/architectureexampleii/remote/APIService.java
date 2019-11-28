package com.example.architectureexampleii.remote;

import com.example.architectureexampleii.model.Categories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("/android/categories.php")
    Call<CategoriesList> getCategoriesList();
}
