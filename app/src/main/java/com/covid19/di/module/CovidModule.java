package com.covid19.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class CovidModule {

    private String BASE_URL;
    private Context context;

    public CovidModule(String BASE_URL, Context context) {
        this.BASE_URL = BASE_URL;
        this.context = context;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor providerLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor =
                new HttpLoggingInterceptor();
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);

        return loggingInterceptor;
    }

    @Singleton
    @Provides
    OkHttpClient providerOkHttpClient(HttpLoggingInterceptor loggingInterceptor){
        return   new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(OkHttpClient client){
        GsonConverterFactory converterFactory = GsonConverterFactory.create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();

    }

    @Singleton
    @Provides
    Context provideContext(){
        return context;
    }
}
