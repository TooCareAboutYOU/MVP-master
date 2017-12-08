package com.zhang.recyclerview.retrofitokhttp.mvp.view;

/**
 * Created by zs on 2017/11/23.
 */

public interface INewsView {
    interface onNewsViewListener<T>{
        void onLoading(boolean load);
        void onNewsSuccess(T bean);
        void onNewsFailed(Throwable ex);
    }

}
