package com.kaushik.mvp.ui.login;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BasePresenter;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V>{

    public LoginPresenter(DataManager dataManager, Context context) {
        super(dataManager,context);
    }

    @Override
    public void onStartLogin(String emailId) {

        getMvpView().showLoading();

        getDataManager().saveEmailId(emailId);
        getDataManager().setLoggedIn();

        if(getMvpContext() instanceof LoginActivity){
            final AppCompatActivity activity = (AppCompatActivity) getMvpContext();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Actions to do after 7 seconds
                    getMvpView().hideLoading();
                    getMvpView().openMainActivity();

                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getMvpContext(),"Login Successfull", Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }, 7000);

        }



       // getMvpView().hideLoading();

       // getMvpView().openMainActivity();



    }
}
