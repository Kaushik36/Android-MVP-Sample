package com.kaushik.mvp.ui.login;

import com.kaushik.mvp.ui.base.MvpPresenter;

/**
 * Created by Kaushik on 26-02-2018.
 */

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onStartLogin(String emailId);
}
