package com.kostya_ubutnu.usersapp.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.kostya_ubutnu.usersapp.dao.PostDao;
import com.kostya_ubutnu.usersapp.db.PostDatabase;
import com.kostya_ubutnu.usersapp.models.Post;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DatabaseModule {


    Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
//    @Singleton
    @Provides
    public PostDatabase provideDatabase(Context context){
        return PostDatabase.getInstance((Application) context);
    }

//    @Singleton
    @Provides
    public PostDao provideDao(PostDatabase database){
        return database.getDao();
    }

}
