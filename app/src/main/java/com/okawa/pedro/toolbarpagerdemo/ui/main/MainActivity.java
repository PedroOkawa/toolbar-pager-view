package com.okawa.pedro.toolbarpagerdemo.ui.main;

import android.os.Bundle;

import com.okawa.pedro.toolbarpagerdemo.R;
import com.okawa.pedro.toolbarpagerdemo.databinding.ActivityMainBinding;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.di.component.main.DaggerMainComponent;
import com.okawa.pedro.toolbarpagerdemo.di.module.main.MainModule;
import com.okawa.pedro.toolbarpagerdemo.presenter.main.MainPresenter;
import com.okawa.pedro.toolbarpagerdemo.ui.common.BaseActivity;

import javax.inject.Inject;

/**
 * Created by pokawa on 27/02/16.
 */
public class MainActivity extends BaseActivity implements MainView {

    private ActivityMainBinding binding;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected int layoutToInflate() {
        return R.layout.activity_main;
    }

    @Override
    protected void initializeComponent(AppComponent appComponent) {
        DaggerMainComponent
                .builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void doOnCreated(Bundle savedInstanceState) {
        /* STORES DATABINDING */
        binding = (ActivityMainBinding) getDataBinding();

        mainPresenter.initialize(binding, getSupportFragmentManager());
    }
}
