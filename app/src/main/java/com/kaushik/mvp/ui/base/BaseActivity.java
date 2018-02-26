package com.kaushik.mvp.ui.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kaushik.mvp.R;
import com.kaushik.mvp.utils.CommonUtils;

public class BaseActivity extends AppCompatActivity implements MvpView{

    private ProgressDialog mProgressDialog;

    @Override
    public void showLoading() {

        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
