package com.okawa.pedro.toolbarpagerdemo;

import android.app.Application;

import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.DaggerAppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.module.app.AppModule;

/**
 * Created by pokawa on 27/02/16.
 */
public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
    }

    protected void initializeComponent() {
        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
