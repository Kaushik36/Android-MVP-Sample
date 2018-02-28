package com.kaushik.mvp.ui.login.user_alert;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kaushik.mvp.MvpApp;
import com.kaushik.mvp.R;
import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.ui.base.BaseDialog;

/**
 * Created by Kaushik on 28-02-2018.
 */

public class UserAlertDialog extends BaseDialog implements UserAlertDialogMvpView, View.OnClickListener{

    private static final String TAG = "UserAlertDialog";

    private Button btn_ok;

    UserAlertDialogPresenter mPresenter;

    public static UserAlertDialog newInstance() {
        UserAlertDialog fragment = new UserAlertDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataManager dataManager = ((MvpApp) getActivity().getApplication()).getDataManager();
        mPresenter = new UserAlertDialogPresenter(dataManager);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.dialog_user_alert, container, false);

        mPresenter.onAttach(this);

        btn_ok = view.findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(this);

        return view;
    }

    @Override
    protected void setUp(View view) {

    }


    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btn_ok:
                mPresenter.onOKButtonClick();
                break;

        }

    }

    @Override
    public void dismissDialog() {

        super.dismissDialog(TAG);

    }
}
