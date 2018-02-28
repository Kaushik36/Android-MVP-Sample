package com.kaushik.mvp.ui.login;

/**
 * Created by Kaushik on 28-02-2018.
 */

public interface OnLoginResponse {

    void onLoginSuccess(String response);
    void onLoginError(String error);

}
