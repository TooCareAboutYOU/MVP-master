package com.mymvp.main;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Administrator on 2017/3/22 0022.
 */

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(final String username,final String password,final OnLoginFinishedListener listener) {
        //模拟登录。创建一个2s后处理程序的操作
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                //判断字符是否为空
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
