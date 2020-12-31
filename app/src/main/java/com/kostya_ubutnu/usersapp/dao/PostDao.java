package com.kostya_ubutnu.usersapp.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kostya_ubutnu.usersapp.models.Post;

import java.util.List;



@Dao
public interface PostDao {

    @Insert
    void insertPost(Post post);

    @Insert
    void insertListPost(List<Post> posts);

    @Query("SELECT * FROM Post_table")
    LiveData<List<Post>> getPosts();
}
