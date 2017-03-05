package com.example.administrator.notebook.Functions;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.notebook.R;
import com.example.administrator.notebook.Sql.UserDo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Write_note extends AppCompatActivity {

    private EditText write_title;
    private EditText write_content;
    private Button add;
    private LoadingDialog dialog;

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                dialog.success();
                dialog.dismiss();
                finish();
            }
        };
    };
    private UserDo userDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_note);

        Toolbar mToolbarTb = (Toolbar) findViewById(R.id.id_tool_bar3);
        mToolbarTb.setTitle("添加日记");
        setSupportActionBar(mToolbarTb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbarTb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //设置返回事件
                onBackPressed();
            }
        });

        write_title = (EditText) findViewById(R.id.write_title);
        write_content = (EditText) findViewById(R.id.write_content);



       //成功界面
        dialog = new LoadingDialog(this);
        //连接数据库
        userDo = new UserDo(Write_note.this);
        //执行日记写入
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = write_title.getText().toString();
                String content = write_content.getText().toString();
                //获取时间
                Date date = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                //System.out.println(sf.format(date));
                if (!title.equals("") && !content.equals("")) {
                    userDo.addSql(title, content, sf.format(date));
                    dialog.show();
                    handler.sendEmptyMessageDelayed(0, 2000);
                }
                else
                    Toast.makeText(Write_note.this, "内容为空!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
