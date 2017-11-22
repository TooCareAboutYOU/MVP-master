package com.zhang.mvpdemo.mvp.view;

import com.zhang.mvpdemo.bean.LoginBean;

/**
 * Created by zhangshuai on 2017/11/22.
 */

public interface ILoginView {

    LoginBean getLoginData();

    void onSuccess();

    void onFailed(String msg);

    void onLoading(boolean load);
}
