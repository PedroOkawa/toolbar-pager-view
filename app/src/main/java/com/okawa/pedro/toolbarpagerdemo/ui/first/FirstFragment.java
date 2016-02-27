package com.okawa.pedro.toolbarpagerdemo.ui.first;

import android.os.Bundle;

import com.okawa.pedro.toolbarpagerdemo.R;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.ui.common.BaseFragment;

/**
 * Created by pokawa on 27/02/16.
 */
public class FirstFragment extends BaseFragment implements FirstView {

    @Override
    protected int layoutToInflate() {
        return R.layout.fragment_first;
    }

    @Override
    protected void initializeComponent(AppComponent appComponent) {

    }

    @Override
    protected void doOnCreated(Bundle savedInstanceState) {

    }
}
