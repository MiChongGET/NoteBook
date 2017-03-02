package com.example.administrator.notebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/3/2 0002.
 */

public class MyAdpter extends BaseAdapter {
    Context context;
    List<String> list;


    public MyAdpter(Context context, List<String> list) {
        this.context = context;
        this.list = list;

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
        String text = list.get(position);
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
        mViewHolder.tx.setText(text);

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
