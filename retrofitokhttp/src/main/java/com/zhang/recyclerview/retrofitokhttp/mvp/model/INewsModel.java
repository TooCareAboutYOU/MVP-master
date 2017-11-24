package com.zhang.recyclerview.retrofitokhttp.mvp.model;


/**
 * Created by zs on 2017/11/23.
 */

public interface INewsModel {
    public interface OnCompleteListenener<T>{
        void onNewsSuccess(T bean);
        void onFailed(Throwable ex);
    }

}
