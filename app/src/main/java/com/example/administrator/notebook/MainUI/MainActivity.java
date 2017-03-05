package com.example.administrator.notebook.MainUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationMenu;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.notebook.Functions.Read_note;
import com.example.administrator.notebook.Functions.Write_note;
import com.example.administrator.notebook.MyAdpter;
import com.example.administrator.notebook.Passwd.BaseActivity;
import com.example.administrator.notebook.R;
import com.example.administrator.notebook.Sql.UserData;
import com.example.administrator.notebook.Sql.UserDo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;

public class MainActivity extends BaseActivity {

    private Toolbar t ;
    private ListView ls;
    private FabSpeedDial fabSpeedDial;

    //监听ListView上下滑动
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private boolean mShow = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fabSpeedDial = (FabSpeedDial) findViewById(R.id.mini_fab);

        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter(){
            @Override
            public boolean onPrepareMenu(NavigationMenu navigationMenu) {
                return true;
            }
        });

        fabSpeedDial.setMenuListener(new SimpleMenuListenerAdapter(){
            @Override
            public boolean onMenuItemSelected(MenuItem menuItem) {

                int id =menuItem.getItemId();
                switch (id){
                    case R.id.riji_write:
                        Toast.makeText(MainActivity.this,"写日记",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, Write_note.class));

                        break;
                    case R.id.activity_setting:
                        Toast.makeText(MainActivity.this,"设置",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(MainActivity.this,"搜索",Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


        ls = (ListView) findViewById(R.id.list_item);
        fillList(ls);
        //监听listview上下滑动
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        ls.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        mFirstY = event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        mCurrentY = event.getY();
                        if (mCurrentY - mFirstY > mTouchSlop) {
                            direction = 0;// down
                        } else if (mFirstY - mCurrentY > mTouchSlop) {
                            direction = 1;// up
                        }
                        if (direction == 1) {

                            //上滑todo
                            fabSpeedDial.hide();

                        } else if (direction == 0) {

                            //下滑todo
                            fabSpeedDial.show();
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });


    }


    //list列表中实现加载数据
    private void fillList(ListView lv) {
        //List<UserData> list = new ArrayList<UserData>();

        //Sqlite数据库测试
        UserDo userDo = new UserDo(MainActivity.this);
       // userDo.addSql();

        final List<UserData> list = userDo.readSql();
        //先判断数据库中有没有数据
//        if (list == null) {
//            userDo.addSql();
//        } else {

            //标题集合
            List<String> titltlist = new ArrayList<>();
            //内容集合
            List<String> contentlist = new ArrayList<>();
            //时间集合
            List<String> timelist = new ArrayList<>();

            //获取ID
            System.out.println("获取ID" + userDo.getCount());
            for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
                UserData userdata = (UserData) iterator.next();
                titltlist.add(userdata.getTitle());
//                contentlist.add(userdata.getContent());
//                timelist.add(userdata.getTime());
            }

            MyAdpter adapter = new MyAdpter(this, list, titltlist);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //根据position获取list的对应位置
                    UserData read = list.get(position);

                    //传递一个UserData对象到Read_note中
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this,Read_note.class);
                    bundle.putSerializable("diary",read);
                    intent.putExtras(bundle);
                    startActivity(intent);

                    Toast.makeText(MainActivity.this, "item" + position, Toast.LENGTH_SHORT).show();
                }
            });

            adapter.setOnImageListner(new MyAdpter.CallBack() {
                @Override
                public void onImageBackListner(View v, int position) {
                    Toast.makeText(MainActivity.this, "image" + position, Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

