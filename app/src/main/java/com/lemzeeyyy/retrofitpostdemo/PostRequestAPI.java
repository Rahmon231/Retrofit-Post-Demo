package com.lemzeeyyy.retrofitpostdemo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostRequestAPI {
    @POST("post")
    Call<PostModel> postDataToServer(@Body PostModel postModel);
}
