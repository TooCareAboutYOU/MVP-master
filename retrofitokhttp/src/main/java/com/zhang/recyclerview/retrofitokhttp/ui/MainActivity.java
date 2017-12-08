package com.zhang.recyclerview.retrofitokhttp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhang.recyclerview.retrofitokhttp.R;
import com.zhang.recyclerview.retrofitokhttp.bean.MusicBean;
import com.zhang.recyclerview.retrofitokhttp.api.ApiService;
import com.zhang.recyclerview.retrofitokhttp.bean.NewsBean;
import com.zhang.recyclerview.retrofitokhttp.mvp.presenter.MusicPresenter;
import com.zhang.recyclerview.retrofitokhttp.mvp.presenter.NewsPresenter;
import com.zhang.recyclerview.retrofitokhttp.mvp.view.IMusicView;
import com.zhang.recyclerview.retrofitokhttp.mvp.view.INewsView;
import com.zhang.recyclerview.retrofitokhttp.utils.RestAdapterUtil;

import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Timer;
import java.util.TimerTask;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends Activity implements IMusicView{

    private static final String TAG = "MainActivity";

    TextView mTvRetrofit,mTvOkhttp,mTimerRetrofit,mTimerOkhttp;

    private int mlCount;
    protected String time;
    private Timer timer = null;
    private TimerTask task = null;
    private Message msg = null;
    protected int sec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        x.view().inject(this);

        findViewById(R.id.btn_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreate(null);
            }
        });


        mTimerRetrofit=findViewById(R.id.tv_timer_retrofit);
        mTimerOkhttp=findViewById(R.id.tv_timer_okhttp);

        mTvRetrofit = findViewById(R.id.tv_retrofit);
        mTvOkhttp=findViewById(R.id.tv_okhttp);

        findViewById(R.id.btn_retrofit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MusicPresenter(MainActivity.this).setMusicData("hdedu");
            }
        });

        //   http://app.mijia.cnlive.com/api_v1/columnprograms.do?cid=ylsd&type=new
        final String uri="http://app.mijia.cnlive.com/api_v1/columnprograms.do?cid=hdedu";
        findViewById(R.id.btn_xuitls).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NewsPresenter(MainActivity.this, new INewsView.onNewsViewListener<NewsBean>() {
                    @Override
                    public void onLoading(boolean load) {
                        if (load) {
                            start(2);
                        }else {
                            stop();
                        }
                    }

                    @Override
                    public void onNewsSuccess(NewsBean bean) {
                        mTvOkhttp.setText(bean.toString());
                    }

                    @Override
                    public void onNewsFailed(Throwable ex) {

                    }
                }).requestData(uri,NewsBean.class);

            }
        });

    }


    /**
     * 计时器
     */
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            switch (msg.what) {
                case 1:
                    mlCount++;
                    int totalSec = 0;
                    int yushu = 0;

                    // 精确到0.01秒
                    totalSec = (int) (mlCount / 100);
                    yushu = (int) (mlCount % 100);

                    // Set time display
                    int min = (totalSec / 60);
                    sec = (totalSec % 60);
                    try {
                        // 格式化算出来的时间为String格式“00:00”
                        time = String.format("%1$02d:%2$02d", sec, yushu);
                        mTimerRetrofit.setText(time);
                    } catch (Exception e) {
                        mTimerRetrofit.setText("" + min + ":" + sec + ":" + yushu);
                        e.printStackTrace();
                        Log.e("MyTimer onCreate", "Format string error.");
                    }
                    break;
                case 2:
                    mlCount++;
                    int totalSec1 = 0;
                    int yushu1 = 0;

                    // 精确到0.01秒
                    totalSec1 = (int) (mlCount / 100);
                    yushu1 = (int) (mlCount % 100);

                    // Set time display
                    int min1 = (totalSec1 / 60);
                    sec = (totalSec1 % 60);
                    try {
                        // 格式化算出来的时间为String格式“00:00”
                        time = String.format("%1$02d:%2$02d", sec, yushu1);
                        mTimerOkhttp.setText(time);
                    } catch (Exception e) {
                        mTimerOkhttp.setText("" + min1 + ":" + sec + ":" + yushu1);
                        e.printStackTrace();
                        Log.e("MyTimer onCreate", "Format string error.");
                    }
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }

    };

    /**
     * 计时器开始计时
     */
    public void start(final int code) {
        if (null == timer) {
            if (null == task) {
                task = new TimerTask() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if (null == msg) {
                            msg = new Message();
                        } else {
                            msg = Message.obtain();
                        }
                        msg.what = code;
                        handler.sendMessage(msg);
                    }
                };
            }
            timer = new Timer(true);
            // timer.schedule(task, 100, 100); // set timer duration
            // set timer duration每隔0.01秒刷新一次
            timer.schedule(task, 10, 10);
        }
    }

    /**
     * 计时器停止
     */
    public void stop() {
        task.cancel();
        task = null;
        timer.cancel(); // Cancel timer
        timer.purge();
        timer = null;
        time="";
        mlCount=0;
        sec=0;
        handler.removeMessages(msg.what);
    }

    @Override
    public void onMusicLoading(boolean load) {
        if (load) {
            start(1);
        }else {
            stop();
        }

    }

    @Override
    public void onMusicSuccess(MusicBean bean) {
        mTvRetrofit.setText(bean.toString());
    }

    @Override
    public void onMusicFailed(RetrofitError error) {
        Toast.makeText(this, "error：" + error, Toast.LENGTH_SHORT).show();
    }
}
