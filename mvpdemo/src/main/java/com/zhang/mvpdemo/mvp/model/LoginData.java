package com.zhang.mvpdemo.mvp.model;

import com.zhang.mvpdemo.bean.LoginBean;

/**
 * Created by zs on 2017/11/22.
 */

public class LoginData implements ILoginModel {
    @Override
    public void login(final String uername, final String userpwd, final OnLoginListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    if (uername.equals("admin") && userpwd.equals("123")){
                        listener.LoginSuccess(new LoginBean(uername,userpwd));
                    }else {
                        listener.LoginFailed("用户名或者密码错误！");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
