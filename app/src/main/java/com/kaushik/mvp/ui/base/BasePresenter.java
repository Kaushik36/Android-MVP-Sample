package com.kaushik.mvp.ui.base;

import android.content.Context;

import com.kaushik.mvp.data.DataManager;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class BasePresenter<V extends MvpView > implements MvpPresenter<V>{

    DataManager mDataManager;
    private V mMvpView;
    private Context context;

    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    public BasePresenter(DataManager dataManager, Context context) {
        mDataManager = dataManager;
        this.context = context;
    }

    @Override
    public void onAttach(V mvpView) {

        mMvpView = mvpView;

    }

    @Override
    public void onDetach() {
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public Context getMvpContext(){
        return context;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

}
