package com.zhang.recyclerview.retrofitokhttp.mvp.listener;

import com.zhang.recyclerview.retrofitokhttp.bean.MusicBean;

import retrofit.RetrofitError;

/**
 * Created by zs on 2017/11/23.
 */

public interface OnMusicListener {
    void onSuccess(MusicBean data);
    void onFailed(RetrofitError error);
}
