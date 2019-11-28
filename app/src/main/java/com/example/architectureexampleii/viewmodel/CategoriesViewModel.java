package com.example.architectureexampleii.viewmodel;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.architectureexampleii.model.Categories;
import com.example.architectureexampleii.repository.CategoriesRepository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class CategoriesViewModel extends ViewModel {

    public String id;
    public String title;
    public String description;
    public String imagepath;

    public MutableLiveData<ArrayList<CategoriesViewModel>> arrayListMutableLiveData = new MutableLiveData<>();

    private ArrayList<CategoriesViewModel> categoriesArrayList;

    private CategoriesRepository categoriesRepository;

    public String getImageUrl(){
        return imagepath;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Picasso.get().load(imageUrl).into(imageView);
    }

    public CategoriesViewModel(){
        categoriesRepository = new CategoriesRepository();
        arrayListMutableLiveData = categoriesRepository.getArrayListMutableLiveData();
    }

    public CategoriesViewModel(Categories categories){
        this.id = categories.getId();
        this.title = categories.getTitle();
        this.description = categories.getDescription();
        this.imagepath = categories.getImagepath();
    }

    public MutableLiveData<ArrayList<CategoriesViewModel>> getArrayListMutableLiveData () {

//        categoriesArrayList = new ArrayList<>();
//        Categories categories = new Categories("1",  "title1", "description", "image1.png");
//        CategoriesViewModel categoriesViewModel = new CategoriesViewModel(categories);
//        categoriesArrayList.add(categoriesViewModel);
//
//        arrayListMutableLiveData.setValue(categoriesArrayList);

        return arrayListMutableLiveData;
    }
}
