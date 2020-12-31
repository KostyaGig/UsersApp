package com.kostya_ubutnu.usersapp.modules;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kostya_ubutnu.usersapp.models.Post;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModel {

    @Provides
    public LiveData<List<Post>> provideMutableLiveData(){
        return new MutableLiveData<>();
    }
}
