package com.okawa.pedro.toolbarpagerdemo.ui.common;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.okawa.pedro.toolbarpagerdemo.App;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;

/**
 * Created by pokawa on 26/02/16.
 */
public abstract class BaseFragment extends Fragment {

    private ViewDataBinding dataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initializeDataBinding(inflater, container);
        initializeComponent(((App)getActivity().getApplication()).getAppComponent());
        doOnCreated(savedInstanceState);
        return getDataBinding().getRoot();
    }

    private void initializeDataBinding(LayoutInflater inflater, @Nullable ViewGroup container) {
        dataBinding = DataBindingUtil.inflate(inflater, layoutToInflate(), container, false);
    }

    protected abstract @LayoutRes int layoutToInflate();
    protected abstract void initializeComponent(AppComponent appComponent);
    protected abstract void doOnCreated(Bundle savedInstanceState);

    public ViewDataBinding getDataBinding() {
        return dataBinding;
    }
}
