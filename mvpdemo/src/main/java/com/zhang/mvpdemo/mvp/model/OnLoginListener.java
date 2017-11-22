package com.zhang.mvpdemo.mvp.model;

import com.zhang.mvpdemo.bean.LoginBean;

/**
 * Created by zs on 2017/11/22.
 */

public interface OnLoginListener {
    void LoginSuccess(LoginBean bean);
    void LoginFailed(String error);
}
