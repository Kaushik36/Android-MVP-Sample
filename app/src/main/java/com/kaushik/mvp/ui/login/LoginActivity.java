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
import com.kaushik.mvp.ui.main.MainActivity;
import com.kaushik.mvp.utils.CommonUtils;

import java.io.File;

public class LoginActivity extends BaseActivity implements LoginMvpView {

    private LoginPresenter loginPresenter;

    private EditText editTextEmail, editTextPassword;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialization();
        clickEvents();
    }

    private void initialization(){

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager);

        loginPresenter.onAttach(this);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        button = (Button) findViewById(R.id.button);

    }

    private void clickEvents(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

    }

    @Override
    public void openMainActivity() {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void attemptLogin(){

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

        loginPresenter.onStartLogin(emailId);

    }

}
