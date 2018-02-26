package com.kaushik.mvp.ui.login;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BasePresenter;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V>{

    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onStartLogin(String emailId) {

        getDataManager().saveEmailId(emailId);
        getDataManager().setLoggedIn();
        getMvpView().openMainActivity();

    }
}
