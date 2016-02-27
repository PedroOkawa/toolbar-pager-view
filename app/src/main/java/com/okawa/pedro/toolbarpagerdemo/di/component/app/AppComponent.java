package com.okawa.pedro.toolbarpagerdemo.di.component.app;

import com.okawa.pedro.toolbarpagerdemo.App;
import com.okawa.pedro.toolbarpagerdemo.di.module.app.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by pokawa on 26/02/16.
 */
@Singleton
@Component(modules = { AppModule.class })
public interface AppComponent {

    void inject(App app);

    /* APP */
    App providesApp();
}
