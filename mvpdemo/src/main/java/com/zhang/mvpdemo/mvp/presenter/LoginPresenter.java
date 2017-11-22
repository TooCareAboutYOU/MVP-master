package com.zhang.mvpdemo.mvp.presenter;

import android.os.Handler;

import com.zhang.mvpdemo.bean.LoginBean;
import com.zhang.mvpdemo.mvp.model.ILoginModel;
import com.zhang.mvpdemo.mvp.model.LoginData;
import com.zhang.mvpdemo.mvp.model.OnLoginListener;
import com.zhang.mvpdemo.mvp.view.ILoginView;

/**
 * Created by zhangshuai on 2017/11/22.
 */

public class LoginPresenter {

    private LoginData mData;
    private ILoginView mView;
    private Handler mHandler=new Handler();

    public LoginPresenter(ILoginView view) {
        mData=new LoginData();
        mView = view;
    }

    public void login(){
        mView.onLoading(true);
        mData.login(mView.getLoginData().getUserName(), mView.getLoginData().getUserPwd(), new OnLoginListener() {
            @Override
            public void LoginSuccess(LoginBean bean) {
                   mHandler.post(new Runnable() {
                       @Override
                       public void run() {
                           mView.onSuccess();
                           mView.onLoading(false);
                       }
                   });
            }

            @Override
            public void LoginFailed(final String error) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.onFailed(error);
                        mView.onLoading(false);
                    }
                });
            }
        });

    }


}
