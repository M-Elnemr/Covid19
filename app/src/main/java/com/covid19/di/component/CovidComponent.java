package com.covid19.di.component;

import android.content.Context;

import com.covid19.di.module.CovidModule;
import com.covid19.view.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = CovidModule.class)
public interface CovidComponent {

//    void inject(MainActivity mainActivity);

    Retrofit exposeRetrofit();
    Context exposeContext();
}
