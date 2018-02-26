package com.kaushik.mvp;

import android.app.Application;

import com.kaushik.mvp.data.DataManager;
import com.kaushik.mvp.data.SharedPrefsHelper;

/**
 * Created by Kaushik on 26-02-2018.
 */

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

    }

    public DataManager getDataManager() {
        return dataManager;
    }

}
