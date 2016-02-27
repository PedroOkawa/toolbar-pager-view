package com.okawa.pedro.toolbarpagerdemo.di.module.second;

import com.okawa.pedro.toolbarpagerdemo.di.scope.Fragment;
import com.okawa.pedro.toolbarpagerdemo.presenter.second.SecondPresenter;
import com.okawa.pedro.toolbarpagerdemo.presenter.second.SecondPresenterImpl;
import com.okawa.pedro.toolbarpagerdemo.ui.second.SecondView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pokawa on 27/02/16.
 */
@Module
public class SecondModule {

    private SecondView firstView;

    public SecondModule(SecondView firstView) {
        this.firstView = firstView;
    }

    @Fragment
    @Provides
    public SecondView providesSecondView() {
        return firstView;
    }

    @Fragment
    @Provides
    public SecondPresenter providesSecondPresenter(SecondView secondView) {
        return new SecondPresenterImpl(secondView);
    }
    
}
