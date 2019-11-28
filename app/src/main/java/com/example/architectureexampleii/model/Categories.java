package com.example.architectureexampleii.model;

import com.google.gson.annotations.SerializedName;

public class Categories {

    @SerializedName("id")
    private String id = "";

    @SerializedName("title")
    private String title = "";

    @SerializedName("description")
    private String description = "";

    @SerializedName("imagepath")
    private String imagepath = "";

    public Categories(String id, String title, String description, String imagepath) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imagepath = imagepath;
    }

    public Categories(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }
}
