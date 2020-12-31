package com.kostya_ubutnu.usersapp.db;

import android.app.Application;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kostya_ubutnu.usersapp.dao.PostDao;
import com.kostya_ubutnu.usersapp.models.Post;

@Database(entities = Post.class,exportSchema = false,version = 1)
public abstract class PostDatabase extends RoomDatabase {

    private static final String TAG = "Networktag";

     static PostDatabase database;
     public abstract PostDao getDao();

     public static PostDatabase getInstance(Application application){
         if (database == null){
             database = Room.databaseBuilder(application,PostDatabase.class,"Posts.db")
                     .allowMainThreadQueries()
                     .build();
             Log.d(TAG, "database create! ");
         }

         return database;
     }

}
