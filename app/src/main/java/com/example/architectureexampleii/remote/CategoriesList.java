package com.example.architectureexampleii.remote;

import com.example.architectureexampleii.model.Categories;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CategoriesList {

    @SerializedName("canseray")
    @Expose
    private ArrayList<Categories> categories = new ArrayList<>();

    public ArrayList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Categories> categories) {
        this.categories = categories;
    }
}
