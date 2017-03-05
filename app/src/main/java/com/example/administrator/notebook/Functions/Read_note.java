package com.example.administrator.notebook.Functions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.notebook.R;
import com.example.administrator.notebook.Sql.UserData;

public class Read_note extends AppCompatActivity {

    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState){
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

        //接收bundle传值
        Intent intent = getIntent();
        UserData userData = (UserData) intent.getSerializableExtra("diary");

        String html = "<h1><font color=\"#ff0000\" size=\"50px\" align=\"center\">" + userData.getTitle() + "</font></h1>" +
                "<p size=\"25px\">"+userData.getContent()+"</p>"+"<p></p><p></p>" +
                "<p></p>"+"<p align=\"right\" size=\"14px\">"+"      "+"——"+userData.getTime()+"</p>";
        textView.setText(Html.fromHtml(html));
    }
}
