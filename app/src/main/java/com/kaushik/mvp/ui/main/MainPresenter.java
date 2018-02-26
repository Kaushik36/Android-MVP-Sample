package com.kaushik.mvp.ui.main;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BasePresenter;
import com.kaushik.mvp.ui.base.MvpView;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class MainPresenter<V extends MainMvpView>  extends BasePresenter<V> implements MainMvpPresenter<V>{

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public String getEmailId() {
        return getDataManager().getEmailId();
    }

    @Override
    public void setUserLoggedOut() {

        getDataManager().clear();
        getMvpView().openSplashActivity();
    }
}
