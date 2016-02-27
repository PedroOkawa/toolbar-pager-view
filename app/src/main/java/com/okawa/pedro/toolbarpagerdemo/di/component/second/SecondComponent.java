package com.okawa.pedro.toolbarpagerdemo.di.component.second;

import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.module.second.SecondModule;
import com.okawa.pedro.toolbarpagerdemo.di.scope.Fragment;
import com.okawa.pedro.toolbarpagerdemo.presenter.second.SecondPresenter;
import com.okawa.pedro.toolbarpagerdemo.ui.second.SecondFragment;
import com.okawa.pedro.toolbarpagerdemo.ui.second.SecondView;

import dagger.Component;

/**
 * Created by pokawa on 26/02/16.
 */
@Fragment
@Component(dependencies = AppComponent.class, modules = SecondModule.class)
public interface SecondComponent {

    void inject(SecondFragment secondFragment);

    SecondView providesSecondView();
    SecondPresenter providesSecondPresenter();

}
