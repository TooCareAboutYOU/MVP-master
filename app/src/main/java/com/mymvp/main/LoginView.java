package com.mymvp.main;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public interface LoginView {

    void showProgress();//显示progress

    void hideProgress();//隐藏progress

    void setUsernameError();//用户名错误

    void setPasswordError();//密码错误

    void navigateToHome();//成功进入主页

}
