package com.kostya_ubutnu.usersapp.modules;

import com.kostya_ubutnu.usersapp.api.NetworkApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    @Provides
    public Retrofit provideRetrofit(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    public NetworkApi provideNetworkApi(Retrofit retrofit){

        return retrofit.create(NetworkApi.class);
    }
}
