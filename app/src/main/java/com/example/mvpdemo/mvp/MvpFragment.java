package com.example.mvpdemo.mvp;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.mvpdemo.base.BaseFragment;
import com.example.mvpdemo.util.ToastUtil;

public abstract class MvpFragment<P extends MvpPresenter> extends BaseFragment implements MvpView {

    private P mPresenter;

    @Override
    public void showToast(String message) {
        ToastUtil.showToast(message);
    }

    @Override
    public void showToast(int id) {
        super.showToast(id);
        ToastUtil.showToast(id);
    }

    @Override
    public Context provideContext() {
        return this.getContext();
    }

    @Override
    public void loading() {

    }

    @Override
    public void succeed() {

    }

    @Override
    public void error() {

    }

    @Override
    public void empty() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.destroy();
            mPresenter = null;
        }
    }

    @NonNull
    public abstract P createPresenter();

    /**
     * Subclass can get the bound presenter by calling this method.
     *
     * 子类通过调用该方法，获得绑定的presenter
     *
     * @return Bound presenter
     */
    protected P getPresenter() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
            mPresenter.attachView(this);
        }
        return mPresenter;
    }
}
