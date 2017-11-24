package com.zhang.recyclerview.retrofitokhttp.api;


import com.zhang.recyclerview.retrofitokhttp.bean.MusicBean;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by zs on 2017/11/23.
 */

public interface ApiService {

    @GET("/columnprograms.do")
    void getMainPageJson(@Query("cid") String cid, Callback<MusicBean> callback);
}
