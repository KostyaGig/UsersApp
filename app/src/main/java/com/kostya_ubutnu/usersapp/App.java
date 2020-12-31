package com.kostya_ubutnu.usersapp;

import android.app.Application;

import com.kostya_ubutnu.usersapp.components.AppComponent;
import com.kostya_ubutnu.usersapp.components.DaggerAppComponent;
import com.kostya_ubutnu.usersapp.modules.DatabaseModule;
import com.kostya_ubutnu.usersapp.modules.NetworkModule;
import com.kostya_ubutnu.usersapp.modules.UtilsModel;

public class App extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        DatabaseModule module = new DatabaseModule(this);
        component = DaggerAppComponent.builder()
                .databaseModule(module)
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
