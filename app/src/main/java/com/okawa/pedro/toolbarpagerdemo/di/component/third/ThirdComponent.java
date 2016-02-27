package com.okawa.pedro.toolbarpagerdemo.di.component.third;

import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.module.third.ThirdModule;
import com.okawa.pedro.toolbarpagerdemo.di.scope.Fragment;
import com.okawa.pedro.toolbarpagerdemo.presenter.third.ThirdPresenter;
import com.okawa.pedro.toolbarpagerdemo.ui.third.ThirdFragment;
import com.okawa.pedro.toolbarpagerdemo.ui.third.ThirdView;

import dagger.Component;

/**
 * Created by pokawa on 26/02/16.
 */
@Fragment
@Component(dependencies = AppComponent.class, modules = ThirdModule.class)
public interface ThirdComponent {

    void inject(ThirdFragment thirdFragment);

    ThirdView providesThirdView();
    ThirdPresenter providesThirdPresenter();

}
