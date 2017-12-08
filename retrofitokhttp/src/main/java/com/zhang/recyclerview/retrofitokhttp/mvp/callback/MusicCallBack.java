package com.zhang.recyclerview.retrofitokhttp.mvp.callback;


import com.zhang.recyclerview.retrofitokhttp.api.ApiService;
import com.zhang.recyclerview.retrofitokhttp.bean.MusicBean;
import com.zhang.recyclerview.retrofitokhttp.mvp.listener.OnMusicListener;
import com.zhang.recyclerview.retrofitokhttp.mvp.model.IMusicModel;
import com.zhang.recyclerview.retrofitokhttp.utils.RestAdapterUtil;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by zs on 2017/11/23.
 */

public class MusicCallBack implements IMusicModel {
    @Override
    public void onMusicData(final String cid, final OnMusicListener listener) {
        //野线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                ApiService api = RestAdapterUtil.getRestAPI("http://app.mijia.cnlive.com/api_v1", ApiService.class);
                api.getMainPageJson(cid,new Callback<MusicBean>() {
                    @Override
                    public void success(MusicBean data, Response response) {
                        listener.onSuccess(data);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        listener.onFailed(error);
                    }
                });
            }
        }).start();

    }
}
