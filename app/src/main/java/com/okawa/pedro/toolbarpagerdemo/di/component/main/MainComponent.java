package com.okawa.pedro.toolbarpagerdemo.di.component.main;

import com.okawa.pedro.toolbarpagerdemo.presenter.main.MainPresenter;
import com.okawa.pedro.toolbarpagerdemo.ui.main.MainActivity;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.module.main.MainModule;
import com.okawa.pedro.toolbarpagerdemo.di.scope.Activity;
import com.okawa.pedro.toolbarpagerdemo.ui.main.MainView;

import dagger.Component;

/**
 * Created by pokawa on 26/02/16.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);

    MainView providesMainView();
    MainPresenter providesMainPresenter();

}
