package com.kaushik.mvp.ui.splash;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BasePresenter;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V>{


    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void decideNextActivity() {

        if (getDataManager().getLoggedInMode()){
            getMvpView().openMainActivity();
        }
        else {
            getMvpView().openLoginActivity();
        }

    }
}
