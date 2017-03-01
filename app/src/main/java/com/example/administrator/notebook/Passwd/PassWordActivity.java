package com.example.administrator.notebook.Passwd;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.notebook.R;

public class PassWordActivity extends Activity {

    MyApplication myApplication;
    private EditText editText;
    private Button sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word);
        myApplication = (MyApplication) getApplication();
        editText = (EditText) findViewById(R.id.passworld);
        sure = (Button) findViewById(R.id.ture);


//        //记录密码
//        sp = getSharedPreferences("michong",MODE_PRIVATE);
//        SharedPreferences.Editor editor = sp.edit();
//        //查询是否是第一次登录
//        boolean isFirstIn = sp.getBoolean("isFirstIn", Boolean.parseBoolean(""));
//        System.out.println(isFirstIn);
//        if (isFirstIn){
//
//            passwd = editText.getText().toString();
//            editor.putString("passwd",passwd);
//            editor.commit();
//
//            System.out.println("是第一次登录");
//        }
//        else {
//            t.setVisibility(View.INVISIBLE);
//            System.out.println("不是第一次登录");
//        }



        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwd = editText.getText().toString();
                if (passwd!=null && passwd.equals(myApplication.password)){
                    System.out.println(passwd+":::"+myApplication.password);

                    Toast.makeText(PassWordActivity.this,"密码正确",Toast.LENGTH_LONG).show();
                    myApplication.isLocked = false;
                    PassWordActivity.this.finish();
                }else {
                    Toast.makeText(PassWordActivity.this,"密码错误",Toast.LENGTH_LONG).show();
                    editText.setText("");
                }
            }
        });
    }
}
