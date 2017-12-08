package com.zhang.recyclerview.retrofitokhttp.mvp.presenter;

import android.os.Handler;
import com.zhang.recyclerview.retrofitokhttp.bean.MusicBean;
import com.zhang.recyclerview.retrofitokhttp.mvp.callback.MusicCallBack;
import com.zhang.recyclerview.retrofitokhttp.mvp.listener.OnMusicListener;
import com.zhang.recyclerview.retrofitokhttp.mvp.view.IMusicView;
import com.zhang.recyclerview.retrofitokhttp.ui.MainActivity;
import retrofit.RetrofitError;

/**
 * Created by zs on 2017/11/23.
 */

public class MusicPresenter {

    private MusicCallBack model;
    private IMusicView mView;
    private Handler mHandler=new Handler();

    public MusicPresenter(IMusicView view) {
        model=new MusicCallBack();
        mView = view;
    }

    public void setMusicData(String cid){
        mView.onMusicLoading(true);
        model.onMusicData(cid, new OnMusicListener() {
            @Override
            public void onSuccess(final MusicBean data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.onMusicLoading(false);
                        mView.onMusicSuccess(data);
                    }
                });

            }

            @Override
            public void onFailed(final RetrofitError error) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.onMusicLoading(false);
                        mView.onMusicFailed(error);
                    }
                });
            }
        });
    }
}
