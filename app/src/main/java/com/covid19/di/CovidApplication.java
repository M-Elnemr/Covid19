package com.covid19.di;

import android.app.Application;

import com.covid19.di.component.CovidComponent;
import com.covid19.di.component.DaggerCovidComponent;

public class CovidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
//        DaggerCovidComponent.builder().create();

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
