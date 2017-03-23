package com.mymvp.main;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);//验证用户名密码

    void onDestroy();
}
