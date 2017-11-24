package com.zhang.recyclerview.retrofitokhttp.mvp.view;

import com.zhang.recyclerview.retrofitokhttp.bean.MusicBean;

import retrofit.RetrofitError;

/**
 * Created by zs on 2017/11/23.
 */

public interface IMusicView {

    void onMusicLoading(boolean load);
    void onMusicSuccess(MusicBean bean);
    void onMusicFailed(RetrofitError error);
}
