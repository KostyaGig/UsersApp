package com.kostya_ubutnu.usersapp.components;

import com.kostya_ubutnu.usersapp.MainActivity;
import com.kostya_ubutnu.usersapp.modules.DatabaseModule;
import com.kostya_ubutnu.usersapp.modules.NetworkModule;
import com.kostya_ubutnu.usersapp.modules.UtilsModel;

import dagger.Component;

@Component(modules = {NetworkModule.class, DatabaseModule.class, UtilsModel.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
