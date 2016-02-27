package com.okawa.pedro.toolbarpagerdemo.di.module.first;

import com.okawa.pedro.toolbarpagerdemo.di.scope.Fragment;
import com.okawa.pedro.toolbarpagerdemo.presenter.first.FirstPresenter;
import com.okawa.pedro.toolbarpagerdemo.presenter.first.FirstPresenterImpl;
import com.okawa.pedro.toolbarpagerdemo.ui.first.FirstView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pokawa on 26/02/16.
 */
@Module
public class FirstModule {

    private FirstView firstView;

    public FirstModule(FirstView firstView) {
        this.firstView = firstView;
    }

    @Fragment
    @Provides
    public FirstView providesFirstView() {
        return firstView;
    }

    @Fragment
    @Provides
    public FirstPresenter providesFirstPresenter(FirstView firstView) {
        return new FirstPresenterImpl(firstView);
    }

}
