package com.kaushik.mvp.ui.login;

import com.kaushik.mvp.ui.base.MvpView;

/**
 * Created by kaushik on 26-02-2018.
 */

public interface LoginMvpView extends MvpView{

    void openMainActivity();

    void showUserAlertDialog(String msg);

}
