package com.example.administrator.notebook.Passwd;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class MyApplication extends Application {


    public boolean isLocked = true;
    public String password="1234";
    LockScreemReceive receive;
    IntentFilter filter;
    @Override
    public void onCreate() {
        super.onCreate();
        receive = new LockScreemReceive();
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        this.registerReceiver(receive,filter);


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        this.unregisterReceiver(receive);
    }

    class LockScreemReceive extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //处理广播
            if (Intent.ACTION_SCREEN_OFF.equals(intent.getAction())){
                isLocked = true;
            }
        }

    }
}
