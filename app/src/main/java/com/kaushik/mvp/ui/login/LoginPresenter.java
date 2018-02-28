package com.kaushik.mvp.ui.login;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BasePresenter;
import com.kaushik.mvp.utils.AppData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V>, OnLoginResponse{

    private Context context;

    public LoginPresenter(DataManager dataManager, Context context) {
        super(dataManager,context);

        this.context = context;

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
                            Toast.makeText(getMvpContext(),"Login Successful", Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }, 5000);

        }



       // getMvpView().hideLoading();

       // getMvpView().openMainActivity();



    }

    @Override
    public void onStartNetworkLogin(String emailId, String password) {
        getLoginResponse(emailId, password);
    }

    /**
     * user login api call
     *
     * @param email
     * @param password
     */
    private void getLoginResponse(String email, String password) {


        if (getMvpView().isNetworkConnected()) {

            getMvpView().showLoading();

            getDataManager().saveEmailId(email);

            Map<String, String> params = new HashMap<String, String>();

            String deviceId = Settings.Secure.getString(context.getContentResolver(),
                    Settings.Secure.ANDROID_ID);

            params.put("email", email);
            params.put("password", password);
            params.put("deviceType", "android");
            params.put("deviceId", deviceId);

            LoginRequester loginRequester = new LoginRequester(context, params, LoginPresenter.this);
            loginRequester.responseLogin();

        } else {
            AppData.showToast(context, "Internet connection not found", false);
        }
    }

    @Override
    public void onLoginSuccess(String response) {

        AppData.showLogMessage("Login Success: "+response);

        AppData.showToast(context, response, false);

        getDataManager().setLoggedIn();

        getMvpView().hideLoading();

        getMvpView().openMainActivity();

    }

    @Override
    public void onLoginError(String error) {

        AppData.showLogMessage("Login Error: "+error);

        getMvpView().hideLoading();

        getMvpView().showUserAlertDialog(error);

    }
}
