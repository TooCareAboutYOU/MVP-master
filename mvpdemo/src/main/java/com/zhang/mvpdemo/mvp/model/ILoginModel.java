package com.zhang.mvpdemo.mvp.model;

/**
 * Created by zhangshuai on 2017/11/22.
 */

public interface ILoginModel {
    public void login(String uername,String userpwd,OnLoginListener listener);
}
