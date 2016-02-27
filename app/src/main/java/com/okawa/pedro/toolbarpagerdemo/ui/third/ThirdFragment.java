package com.okawa.pedro.toolbarpagerdemo.ui.third;

import android.os.Bundle;

import com.okawa.pedro.toolbarpagerdemo.R;
import com.okawa.pedro.toolbarpagerdemo.di.component.app.AppComponent;
import com.okawa.pedro.toolbarpagerdemo.ui.common.BaseFragment;

/**
 * Created by pokawa on 27/02/16.
 */
public class ThirdFragment extends BaseFragment implements ThirdView {

    @Override
    protected int layoutToInflate() {
        return R.layout.fragment_third;
    }

    @Override
    protected void initializeComponent(AppComponent appComponent) {

    }

    @Override
    protected void doOnCreated(Bundle savedInstanceState) {

    }
}
