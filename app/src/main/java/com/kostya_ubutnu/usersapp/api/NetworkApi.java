package com.kostya_ubutnu.usersapp.api;

import com.kostya_ubutnu.usersapp.models.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkApi {

    @GET("posts")
    Observable<List<Post>> getPosts();
}
