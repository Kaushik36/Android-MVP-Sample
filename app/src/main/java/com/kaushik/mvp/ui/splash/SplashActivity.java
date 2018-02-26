package com.kaushik.mvp.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.kaushik.mvp.MvpApp;
import com.kaushik.mvp.R;
import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BaseActivity;
import com.kaushik.mvp.ui.login.LoginActivity;
import com.kaushik.mvp.ui.main.MainActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView{

    private SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initialization();
    }

    private void initialization(){

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();

        mSplashPresenter = new SplashPresenter(dataManager);

        mSplashPresenter.onAttach(this);

        mSplashPresenter.decideNextActivity();

    }

    @Override
    public void openMainActivity() {

        Intent mainIntent  = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(mainIntent);
        finish();

    }

    @Override
    public void openLoginActivity() {

        Intent mainIntent  = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(mainIntent);
        finish();

    }
}
