package com.example.administrator.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.notebook.Sql.UserData;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class MyAdpter extends BaseAdapter {
    Context context;
    List<UserData> list;
    List<String> titlelist;

    public MyAdpter(Context context, List<UserData> list,List<String> titlelist) {
        this.context = context;
        this.list = list;
        this.titlelist = titlelist;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView( final int position, View convertView, ViewGroup parent) {

//        UserData userData = list.iterator().next();
//        String title = userData.getTitle();
//        String time = userData.getTime();

        String title = titlelist.get(position);

        ViewHolder mViewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.test, null, false);
            mViewHolder = new ViewHolder();
            mViewHolder.tx = (TextView) convertView.findViewById(R.id.item_txt);
            mViewHolder.img = (ImageView) convertView.findViewById(R.id.item_img);

            convertView.setTag(mViewHolder);

        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.tx.setText(title);

        mViewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallBack.onImageBackListner(v,position);
            }
        });



        return convertView;
    }


    class ViewHolder {
        private TextView tx;
        private ImageView img;
    }



    CallBack mCallBack;

    public void setOnImageListner(CallBack mCallBack) {
        this.mCallBack = mCallBack;
    }

    public interface CallBack {
        void onImageBackListner(View v,int position);
    }
}
