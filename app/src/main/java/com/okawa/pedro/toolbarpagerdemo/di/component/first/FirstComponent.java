package com.okawa.pedro.toolbarpagerdemo.di.component.first;

import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.module.first.FirstModule;
import com.okawa.pedro.toolbarpagerdemo.di.scope.Fragment;
import com.okawa.pedro.toolbarpagerdemo.presenter.first.FirstPresenter;
import com.okawa.pedro.toolbarpagerdemo.ui.first.FirstFragment;
import com.okawa.pedro.toolbarpagerdemo.ui.first.FirstView;

import dagger.Component;

/**
 * Created by pokawa on 26/02/16.
 */
@Fragment
@Component(dependencies = AppComponent.class, modules = FirstModule.class)
public interface FirstComponent {

    void inject(FirstFragment firstFragment);

    FirstView providesFirstView();
    FirstPresenter providesFirstPresenter();

}
