package com.kaushik.mvp.ui.splash;

import com.kaushik.mvp.ui.base.MvpPresenter;

/**
 * Created by DAT-Asset-131 on 26-02-2018.
 */

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void decideNextActivity();

}
