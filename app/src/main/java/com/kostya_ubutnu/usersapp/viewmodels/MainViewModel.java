package com.kostya_ubutnu.usersapp.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kostya_ubutnu.usersapp.interfaces.NetworkData;
import com.kostya_ubutnu.usersapp.models.Post;
import com.kostya_ubutnu.usersapp.repositories.NetworkRepositoriesImpl;

import java.util.List;

import javax.inject.Inject;

public class MainViewModel extends ViewModel implements NetworkData {

    private static final String TAG = "Networktag";

    @Inject
    LiveData<List<Post>> liveData;

    @Inject
    NetworkRepositoriesImpl repository;

    @Inject
    public MainViewModel() {

    }


    @Override
    public void getDataPosts() {
        Log.d(TAG, "viewmodel getDataPosts: ");
        repository.getDataPosts();
    }

    @Override
    public void getPosts() {
        Log.d(TAG, "viewmodel getPosts: ");
        repository.getPosts();
        liveData = repository.getLiveData();
    }

    public LiveData<List<Post>> getLiveData(){
        return liveData;
    }

}
