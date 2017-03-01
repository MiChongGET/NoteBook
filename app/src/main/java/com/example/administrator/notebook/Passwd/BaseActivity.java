package com.example.administrator.notebook.Passwd;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by Administrator on 2017/2/24 0024.
 */

public class BaseActivity extends Activity {

    MyApplication myApplication ;


    @Override
    protected void onResume() {
        super.onResume();

        myApplication = (MyApplication) getApplication();
        //判断是否要跳到密码界面
        if (myApplication.isLocked){
            Intent intent = new Intent(this,PassWordActivity.class);
            startActivity(intent);
        }
    }
}
