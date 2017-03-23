package com.mymvp.main;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public interface LoginModel {

    interface OnLoginFinishedListener {
        void onUsernameError();//用户名错误

        void onPasswordError();//密码错误

        void onSuccess();//成功
    }
    //连接登录时的操作
    void login(String username, String password, OnLoginFinishedListener listener);

}
