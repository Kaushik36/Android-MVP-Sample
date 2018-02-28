package com.kaushik.mvp.ui.base;

import android.view.View;

/**
 * Created by kaushik on 26-02-2018.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();


}
