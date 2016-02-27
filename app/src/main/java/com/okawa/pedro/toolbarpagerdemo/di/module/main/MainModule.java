package com.okawa.pedro.toolbarpagerdemo.di.module.main;

import com.okawa.pedro.toolbarpagerdemo.di.scope.Activity;
import com.okawa.pedro.toolbarpagerdemo.presenter.main.MainPresenter;
import com.okawa.pedro.toolbarpagerdemo.presenter.main.MainPresenterImpl;
import com.okawa.pedro.toolbarpagerdemo.ui.main.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pokawa on 26/02/16.
 */
@Module
public class MainModule {

    private MainView mainView;

    public MainModule(MainView mainView) {
        this.mainView = mainView;
    }

    @Activity
    @Provides
    public MainView providesMainView() {
        return mainView;
    }

    @Activity
    @Provides
    public MainPresenter providesMainPresenter(MainView mainView) {
        return new MainPresenterImpl(mainView);
    }

}
