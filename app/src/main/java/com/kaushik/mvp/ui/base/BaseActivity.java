package com.kaushik.mvp.ui.base;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.kaushik.mvp.utils.AppData;
import com.kaushik.mvp.utils.CommonUtils;

public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.Callback{

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

    @Override
    public boolean isNetworkConnected() {
        return AppData.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}
