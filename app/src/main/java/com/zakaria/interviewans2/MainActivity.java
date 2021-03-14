package com.zakaria.interviewans2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.zakaria.interviewans2.main.data.remote.ApiUtils;
import com.zakaria.interviewans2.main.model.Post;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public ProgressBar pd;
    //for category show
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CustomAdapter adapter;
    Context context;
    ImageView imageView;
    List<Post> modelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleer_id);
        //refreshLayout = findViewById(R.id.swipe_container);
        recyclerView.setHasFixedSize(true);
        adapter = new com.zakaria.interviewans2.CustomAdapter( MainActivity.this, modelList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        //recyclerView.setLayoutManager(new LinearLayoutManager(View.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        getData();


    }


    private void getData() {

        //pd.setMessage("Loading...");
        //pd.setVisibility(View.VISIBLE);

        Call<List<Post>> categoryList = ApiUtils.getAPIService().getpost();

       categoryList.enqueue(new Callback<List<Post>>() {
           @Override
           public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
               List<Post> posts = response.body();
               adapter.setData(posts);
           }

           @Override
           public void onFailure(Call<List<Post>> call, Throwable t) {

           }
       });

//        touristList.enqueue(new Callback<List<Category>>() {
//            @Override
//            public void onResponse(Call<List<Tourist>> call, Response<List<Tourist>> response) {
//                List<Tourist> posts = response.body();
//                adapter.setData(posts);
//                recyclerView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Tourist>> call, Throwable t) {
//
//            }
//        });
    }

}