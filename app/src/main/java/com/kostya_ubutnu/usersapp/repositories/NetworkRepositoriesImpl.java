package com.kostya_ubutnu.usersapp.repositories;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Insert;

import com.kostya_ubutnu.usersapp.api.NetworkApi;
import com.kostya_ubutnu.usersapp.dao.PostDao;
import com.kostya_ubutnu.usersapp.interfaces.NetworkData;
import com.kostya_ubutnu.usersapp.models.Post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.POST;

public class NetworkRepositoriesImpl implements NetworkData {

    private static final String TAG = "Networktag";

    @Inject
    PostDao dao;

    @Inject
    NetworkApi api;

    @Inject
    LiveData<List<Post>> liveData;

    @Inject
    Context context;

    @Inject public NetworkRepositoriesImpl(){}


    @Override
    public void getDataPosts() {
        Observable<List<Post>> posts = api.getPosts();

        if (posts == null){
            Log.d(TAG, "getDataPosts:null ");
        } else {
            Log.d(TAG, "getDataPosts: not null");
        }

        assert posts != null;
        posts
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        
                        Log.d(TAG, "onNext: ");
                        insertList(posts);
                        Log.d(TAG, "onNext: List inserted!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "Ошибка,проверьте подключение к интернету!", Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    @Override
    public void getPosts() {
        Log.d(TAG, "repository getPosts: ");
        liveData = dao.getPosts();
    }

    public LiveData<List<Post>> getLiveData(){
        return liveData;
    }

    private void insertList(List<Post> posts){
        AsynckInsertList task = new AsynckInsertList(dao);
        task.execute(posts);
    }

    class AsynckInsertList extends AsyncTask<List<Post>,Void,Void> {

        private PostDao dao;

        private AsynckInsertList(PostDao dao){
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(List<Post>... lists) {
            Log.d(TAG, "doInBackground: ");
            dao.insertListPost(lists[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(context, "Data was inserted!", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "onPostExecute: ");
        }
    }

}
