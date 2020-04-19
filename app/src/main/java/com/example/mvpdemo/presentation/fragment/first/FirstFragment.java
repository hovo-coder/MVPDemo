package com.example.mvpdemo.presentation.fragment.first;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.mvpdemo.R;
import com.example.mvpdemo.mvp.MvpFragment;

public class FirstFragment extends MvpFragment<FirstContract.Presenter> implements FirstContract.View, View.OnClickListener {

    private Toolbar mToolbar;
    private Button mBtnGetData;

    public static FirstFragment newInstance() {
        Bundle args = new Bundle();
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public FirstContract.Presenter createPresenter() {
        return new FirstPresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_first;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /**
         * Must use
         * 编码规范，必须使用
         */
        getPresenter().start();

        initView(view);
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        // TODO: 18-5-8
    }

    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        // TODO: 18-5-8
    }

    private void initView(View view) {
        mToolbar = view.findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.fragment_first);
        mBtnGetData = view.findViewById(R.id.btn_get_data);
        bindOnClickLister(this, mBtnGetData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_data:
                getPresenter().getData();
                break;
        }
    }

    @Override
    public void setBtnGetDataEnabled(boolean enabled) {
        mBtnGetData.setEnabled(enabled);
    }

    @Override
    public void showData(String data) {
        showToast(data);
    }
}
