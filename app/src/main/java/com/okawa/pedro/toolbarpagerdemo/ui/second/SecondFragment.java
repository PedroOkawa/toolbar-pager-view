package com.okawa.pedro.toolbarpagerdemo.ui.second;

import android.os.Bundle;

import com.okawa.pedro.toolbarpagerdemo.R;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.ui.common.BaseFragment;

/**
 * Created by pokawa on 27/02/16.
 */
public class SecondFragment extends BaseFragment implements SecondView {

    @Override
    protected int layoutToInflate() {
        return R.layout.fragment_second;
    }

    @Override
    protected void initializeComponent(AppComponent appComponent) {

    }

    @Override
    protected void doOnCreated(Bundle savedInstanceState) {

    }
}
