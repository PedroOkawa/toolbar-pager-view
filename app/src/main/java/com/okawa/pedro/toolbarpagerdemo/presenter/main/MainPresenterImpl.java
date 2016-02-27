package com.okawa.pedro.toolbarpagerdemo.presenter.main;

import android.support.v4.app.FragmentManager;

import com.okawa.pedro.toolbarpagerdemo.R;
import com.okawa.pedro.toolbarpagerdemo.databinding.ActivityMainBinding;
import com.okawa.pedro.toolbarpagerdemo.ui.first.FirstFragment;
import com.okawa.pedro.toolbarpagerdemo.ui.main.MainView;
import com.okawa.pedro.toolbarpagerdemo.ui.second.SecondFragment;
import com.okawa.pedro.toolbarpagerdemo.ui.third.ThirdFragment;

/**
 * Created by pokawa on 27/02/16.
 */
public class MainPresenterImpl implements MainPresenter {

    private MainView mainView;

    public MainPresenterImpl(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void initialize(ActivityMainBinding binding, FragmentManager fragmentManager) {

        /* INITIALIZES THE ADAPTER SETTING A FRAGMENT MANAGER */
        binding.tpvActivityMain.setAdapter(fragmentManager);

        /* ADD SOME PAGES (FRAGMENTS) */
        /* ADDING WITHOUT A SPECIFIC ICON */
        binding.tpvActivityMain.addPage(new FirstFragment());

        /* ADDING WITH A SPECIFIC ICON */
        binding.tpvActivityMain.addPage(R.mipmap.ic_social, new SecondFragment());
        binding.tpvActivityMain.addPage(R.mipmap.ic_search, new ThirdFragment());
    }
}
