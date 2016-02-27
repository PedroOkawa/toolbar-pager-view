package com.okawa.pedro.toolbarpagerdemo.di.module.third;

import com.okawa.pedro.toolbarpagerdemo.di.scope.Fragment;
import com.okawa.pedro.toolbarpagerdemo.presenter.third.ThirdPresenter;
import com.okawa.pedro.toolbarpagerdemo.presenter.third.ThirdPresenterImpl;
import com.okawa.pedro.toolbarpagerdemo.ui.third.ThirdView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pokawa on 27/02/16.
 */
@Module
public class ThirdModule {

    private ThirdView firstView;

    public ThirdModule(ThirdView firstView) {
        this.firstView = firstView;
    }

    @Fragment
    @Provides
    public ThirdView providesThirdView() {
        return firstView;
    }

    @Fragment
    @Provides
    public ThirdPresenter providesThirdPresenter(ThirdView thirdView) {
        return new ThirdPresenterImpl(thirdView);
    }

}