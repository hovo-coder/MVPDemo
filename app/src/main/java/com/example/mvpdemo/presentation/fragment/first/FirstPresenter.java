package com.example.mvpdemo.presentation.fragment.first;

import android.os.Handler;

import com.example.mvpdemo.mvp.MvpBasePresenter;

public class FirstPresenter extends MvpBasePresenter<FirstContract.View> implements FirstContract.Presenter {

    private static final String TAG = "FirstPresenter";

    @Override
    public void start() {
        super.start();
        /**
         * You can init action here
         *
         * 你可以在这里进行一些初始操作
         */
    }

    @Override
    public void getData() {
        /**
         * set button status
         *
         * 设置UI按钮的状态
         */
        getView().setBtnGetDataEnabled(false);

        /**
         * Analog network request data
         *
         * 模拟网络请求数据
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isViewAttached()) return;

                getView().showData("Hello MVPFrame FirstFragment");
                getView().setBtnGetDataEnabled(true);
            }
        }, 2000);
    }
}