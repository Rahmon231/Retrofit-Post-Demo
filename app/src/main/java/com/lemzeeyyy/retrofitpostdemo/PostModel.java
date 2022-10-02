package com.lemzeeyyy.retrofitpostdemo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostModel {
    private String title;
    @SerializedName("data")
    @Expose
    private String postBody;
    json json;

    public PostModel() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
    public json getJson(){
        return  json;
    }
}

