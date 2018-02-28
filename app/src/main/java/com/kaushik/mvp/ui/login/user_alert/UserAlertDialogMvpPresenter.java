package com.kaushik.mvp.ui.login.user_alert;

import com.kaushik.mvp.ui.base.MvpPresenter;

/**
 * Created by Kaushik on 28-02-2018.
 */

public interface UserAlertDialogMvpPresenter<V extends UserAlertDialogMvpView> extends MvpPresenter<V> {

    void onOKButtonClick();

}
