package com.zhang.recyclerview.retrofitokhttp.mvp.model;

import android.content.Context;

import com.zhang.recyclerview.retrofitokhttp.mvp.listener.OnMusicListener;

/**
 * Created by zs on 2017/11/23.
 */

public interface IMusicModel {
    void onMusicData(String cid, OnMusicListener listener);
}
