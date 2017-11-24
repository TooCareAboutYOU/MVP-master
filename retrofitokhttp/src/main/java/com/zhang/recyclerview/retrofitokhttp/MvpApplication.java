package com.zhang.recyclerview.retrofitokhttp;

import android.app.Application;

import com.zhang.recyclerview.retrofitokhttp.utils.DeviceUtil;

import org.xutils.x;

/**
 * Created by zs on 2017/11/23.
 */

public class MvpApplication extends Application {

    public static MvpApplication sMvpApplication;
    public static String ime="";

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);

        sMvpApplication=this;
        ime= DeviceUtil.getIEMI(this);
    }

    public static synchronized MvpApplication getInstance() { return sMvpApplication; }

}
