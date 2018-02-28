package com.kaushik.mvp.ui.login.user_alert;

import android.content.Context;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BasePresenter;
import com.kaushik.mvp.ui.base.MvpView;

/**
 * Created by Kaushik on 28-02-2018.
 */

public class UserAlertDialogPresenter<V extends UserAlertDialogMvpView> extends BasePresenter<V> implements UserAlertDialogMvpPresenter<V>{

    public static final String TAG = "UserAlertDialogPresenter";

    public UserAlertDialogPresenter(DataManager dataManager) {
        super(dataManager);
    }


    @Override
    public void onOKButtonClick() {

        getMvpView().dismissDialog();

    }
}
