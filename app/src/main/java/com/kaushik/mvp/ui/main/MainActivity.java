package com.kaushik.mvp.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kaushik.mvp.MvpApp;
import com.kaushik.mvp.R;
import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BaseActivity;
import com.kaushik.mvp.ui.splash.SplashActivity;

public class MainActivity extends BaseActivity implements MainMvpView{

    private TextView textViewShow;
    private Button buttonLogout;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();
        clickEvents();
    }

    private void initialization(){

        DataManager dataManager = ((MvpApp) getApplication()).getDataManager();
        mainPresenter = new MainPresenter(dataManager);
        mainPresenter.onAttach(this);

        textViewShow = (TextView) findViewById(R.id.textViewShow);

        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        textViewShow.setText(mainPresenter.getEmailId());

    }

    private void clickEvents(){

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.setUserLoggedOut();
            }
        });
    }

    @Override
    public void openSplashActivity() {

        Intent intent = new Intent(MainActivity.this, SplashActivity.class);
        // set the new task and clear flags
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }
}
