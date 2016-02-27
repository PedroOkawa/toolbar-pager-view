package com.okawa.pedro.toolbarpagerdemo.di.module.app;

import com.okawa.pedro.toolbarpagerdemo.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pokawa on 26/02/16.
 */
@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Singleton
    @Provides
    public App providesApp() {
        return app;
    }

}
