package com.lemzeeyyy.retrofitpostdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText1);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callRetrofit();
            }
        });


    }

    private void callRetrofit() {
        String postBody = editText.getText().toString().trim();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostRequestAPI requestAPI = retrofit.create(PostRequestAPI.class);
        PostModel postModel = new PostModel();
        postModel.setPostBody(postBody);
        postModel.setTitle("post1");

        Call<PostModel> call = requestAPI.postDataToServer(postModel);
        call.enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                textView.setText(response.body().getJson().getData());
                Log.d("TAG", "onResponse: "+response.body().getJson().getData());
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Log.d("TAG", "onFailure: "+t.getMessage());
            }
        });
    }
}