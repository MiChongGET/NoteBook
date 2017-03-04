package com.example.administrator.notebook.Functions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.notebook.R;

public class Read_note extends AppCompatActivity {

    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_note);

        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.id_tool_bar3);
        mToolbarTb.setTitle("查看日记本");

        setSupportActionBar(mToolbarTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();//设置返回事件
            }
        });

        //显示日记
        textView = (TextView) findViewById(R.id.title);

        String html = "<h1>测试啊本月已成功邀请 <font color=\"#ff0000\" size=\"40px\">" + 100 + "</font>人</h1>";
        textView.setText(Html.fromHtml(html));
    }
}
