package com.zhang.recyclerview.retrofitokhttp.mvp.presenter;

import android.app.Activity;
import android.os.Handler;
import com.zhang.recyclerview.retrofitokhttp.mvp.model.INewsModel;
import com.zhang.recyclerview.retrofitokhttp.mvp.model.NewsModel;
import com.zhang.recyclerview.retrofitokhttp.mvp.view.INewsView;

/**
 * Created by zs on 2017/11/23.
 */

public class NewsPresenter<T> {
    private NewsModel mModel;
    private INewsView.onNewsViewListener mView;
    private Handler mHandler=new Handler();
//    private Class<T> mTClass=null;

    public NewsPresenter(Activity activity,INewsView.onNewsViewListener<T> view) {
        mModel=new NewsModel(activity);
        mView = view;
    }

    public void requestData(String uri,Class<T> mTClass){
        mView.onLoading(true);
        mModel.onData(uri,mTClass, new INewsModel.OnCompleteListenener<T>() {
            @Override
            public void onNewsSuccess(final T bean) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.onLoading(false);
                        mView.onNewsSuccess(bean);
                    }
                });
            }

            @Override
            public void onFailed(final Throwable ex) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.onLoading(false);
                        mView.onNewsFailed(ex);
                    }
                });
            }
        });
    }
}
