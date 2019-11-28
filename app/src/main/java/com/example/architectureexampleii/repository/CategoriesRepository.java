package com.example.architectureexampleii.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.architectureexampleii.model.Categories;
import com.example.architectureexampleii.remote.APIService;
import com.example.architectureexampleii.remote.CategoriesList;
import com.example.architectureexampleii.remote.RetrofitHelper;
import com.example.architectureexampleii.viewmodel.CategoriesViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesRepository {

    public MutableLiveData<ArrayList<CategoriesViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<CategoriesViewModel> viewModelArrayList;
    private ArrayList<Categories> items;


    public CategoriesRepository(){

    }

    public MutableLiveData<ArrayList<CategoriesViewModel>> getArrayListMutableLiveData() {

        APIService apiService = RetrofitHelper.getAPIService();
        Call<CategoriesList> categoriesListCall = apiService.getCategoriesList();

        categoriesListCall.enqueue(new Callback<CategoriesList>() {
            @Override
            public void onResponse(Call<CategoriesList> call, Response<CategoriesList> response) {
                items = response.body().getCategories();
                Categories categories;
                CategoriesViewModel categoriesViewModel;
                viewModelArrayList = new ArrayList<>();

                for (int i = 0; i < items.size(); i++){
                    categories = new Categories(items.get(i).getId(),
                            items.get(i).getTitle(), items.get(i).getDescription(),
                            items.get(i).getImagepath());

                    //getimagepath review

                    categoriesViewModel = new CategoriesViewModel(categories);
                    viewModelArrayList.add(categoriesViewModel);
                }

                arrayListMutableLiveData.setValue(viewModelArrayList);
            }

            @Override
            public void onFailure(Call<CategoriesList> call, Throwable t) {

            }
        });

        return arrayListMutableLiveData;
    }
}
