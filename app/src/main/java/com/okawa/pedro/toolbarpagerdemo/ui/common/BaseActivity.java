package com.okawa.pedro.toolbarpagerdemo.ui.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.okawa.pedro.toolbarpagerdemo.App;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;

/**
 * Created by pokawa on 26/02/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ViewDataBinding dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeDataBinding();
        initializeComponent(((App) getApplication()).getAppComponent());
        doOnCreated(savedInstanceState);
    }

    private void initializeDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, layoutToInflate());
    }

    protected abstract @LayoutRes int layoutToInflate();
    protected abstract void initializeComponent(AppComponent appComponent);
    protected abstract void doOnCreated(Bundle savedInstanceState);

    public ViewDataBinding getDataBinding() {
        return dataBinding;
    }
}
