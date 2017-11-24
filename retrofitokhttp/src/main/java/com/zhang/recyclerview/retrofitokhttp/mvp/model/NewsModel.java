package com.zhang.recyclerview.retrofitokhttp.mvp.model;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zs on 2017/11/23.
 */

public class NewsModel<T> {

    public NewsModel(Activity activity){ x.view().inject(activity); }



    public void onData(final String uri, final Class<T> t, final INewsModel.OnCompleteListenener<T> listener){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                RequestParams params = new RequestParams(uri);
//                x.http().get(params, new org.xutils.common.Callback.CommonCallback<String>() {
//                    @Override
//                    public void onSuccess(String result) {
//                        Gson gson = new Gson();
//                        T bean = gson.fromJson(result, t);
//                        listener.onNewsSuccess(bean);
//                    }
//
//                    @Override
//                    public void onError(Throwable ex, boolean isOnCallback) {
//                        listener.onFailed(ex);
//                    }
//
//                    @Override
//                    public void onCancelled(CancelledException cex) {}
//
//                    @Override
//                    public void onFinished() {}
//                });
//            }
//        }).start();


        //创建一个缓存线程池，如果线程池的长度超过处理的需要，可灵活回收空闲线程，若无可回收，则新建线程
        //线程池尾无限大，当执行第二个任务时第一个任务已经完成，回复用第一个任务的线程，而不用新建线程
        ExecutorService cacheThreadPool=Executors.newCachedThreadPool();
        getData(uri, t, listener, cacheThreadPool);


        //定长线程池，可控制线程池的最大并发数，超出的线程会在队列中等待
        //定长线程池的大小最好根据系统资源进行配置，如 Runtime.getRuntime().availableProcessors();
//        ExecutorService fixedThreadPool=Executors.newFixedThreadPool(3);
//        getData(uri, t, listener, fixedThreadPool);


        //定长线程池,支持定时及周期性任务执行
//        ExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
//        getData(uri, t, listener, scheduledThreadPool);

        //单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定的顺序(FIFO,LIFO,优先级)执行
//        ExecutorService singleThreadExecutor= Executors.newSingleThreadExecutor();
//        getData(uri, t, listener, singleThreadExecutor);
}

    private void getData(final String uri, final Class<T> t, final INewsModel.OnCompleteListenener<T> listener, ExecutorService executor) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                RequestParams params = new RequestParams(uri);
                x.http().get(params, new org.xutils.common.Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson = new Gson();
                        T bean = gson.fromJson(result, t);
                        listener.onNewsSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        listener.onFailed(ex);
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {}

                    @Override
                    public void onFinished() {}
                });
            }
        });
    }


}
