package com.example.administrator.notebook.MainUI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.notebook.MyAdpter;
import com.example.administrator.notebook.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mListView= (ListView) findViewById(R.id.second_listview);

        fillList(mListView);
    }


    //list列表中实现加载数据
    private void fillList(ListView lv) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <50 ; i++) {
            list.add("SecondActivity"+i);
        }

        MyAdpter adapter=new MyAdpter(this,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this, "item"+position, Toast.LENGTH_SHORT).show();
            }
        });

//     Instant run

        adapter.setOnImageListner(new MyAdpter.CallBack() {
            @Override
            public void onImageBackListner(View v, int position) {
                Toast.makeText(SecondActivity.this, "SecondActivity"+position, Toast.LENGTH_SHORT).show();
            }
        });


    }

}
