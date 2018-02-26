package com.kaushik.mvp.ui.main;

import com.kaushik.mvp.ui.base.MvpPresenter;

/**
 * Created by Kaushik on 26-02-2018.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    String getEmailId();
    void setUserLoggedOut();

}
