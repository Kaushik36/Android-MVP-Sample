package com.kaushik.mvp.ui.login;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kaushik.mvp.MvpApp;
import com.kaushik.mvp.R;
import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BaseActivity;
import com.kaushik.mvp.ui.login.user_alert.UserAlertDialog;
import com.kaushik.mvp.ui.main.MainActivity;
import com.kaushik.mvp.utils.CommonUtils;

import java.io.File;

public class LoginActivity extends BaseActivity implements LoginMvpView, View.OnClickListener {

    private LoginPresenter loginPresenter;

    private EditText editTextEmail, editTextPassword;

    private Button btn_login, btn_login_network;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialization();
        clickEvents();
    }

    private void initialization() {

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager, LoginActivity.this);

        loginPresenter.onAttach(this);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        btn_login = findViewById(R.id.btn_login);
        btn_login_network = findViewById(R.id.btn_login_network);

    }

    private void clickEvents() {

        btn_login.setOnClickListener(this);
        btn_login_network.setOnClickListener(this);

    }

    @Override
    public void openMainActivity() {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void showUserAlertDialog(String msg) {

        UserAlertDialog.newInstance().show(getSupportFragmentManager());

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btn_login:
                attemptLogin(false);
                break;

            case R.id.btn_login_network:
                attemptLogin(true);
                break;

            default:
                break;

        }

    }

    private void attemptLogin(boolean isAPICall) {

        String emailId = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (!CommonUtils.isEmailValid(emailId)) {
            Toast.makeText(this, "Enter correct Email", Toast.LENGTH_LONG).show();
            return;
        }

        if (password == null || password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show();
            return;
        }

        if (isAPICall){
            loginPresenter.onStartNetworkLogin(emailId, password);
        }
        else {
            loginPresenter.onStartLogin(emailId);

        }

    }

}
