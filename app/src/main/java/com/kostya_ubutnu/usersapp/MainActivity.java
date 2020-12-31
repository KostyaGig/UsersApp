package com.kostya_ubutnu.usersapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kostya_ubutnu.usersapp.db.PostDatabase;
import com.kostya_ubutnu.usersapp.models.Post;
import com.kostya_ubutnu.usersapp.viewmodels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    //GET
    //https://jsonplaceholder.typicode.com/posts

    private static final String TAG = "Networktag";

    @Inject
    MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getComponent().inject(this);
        setContentView(R.layout.activity_main);
        viewModel.getPosts();

        viewModel.getLiveData().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts) {
                Log.d(TAG, "onChanged: ");
                if (posts == null){
                    Log.d(TAG, "posts = null ");
                    return;
                }
                for(Post post:posts){
                    Log.d(TAG, "Posts " + post.getTitle() + "\\n");
                }
            }
        });

        findViewById(R.id.getTV).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewModel.getDataPosts();
//                List<Post> posts = new ArrayList<>();
//                posts.add(new Post("1","1","1","1"));
//                PostDatabase.getInstance((Application) getApplicationContext()).getDao().insertListPost(posts);
//                Log.d(TAG, "onClick: DATA INSERT");
            }
        });

    }
}
