package com.example.classno3_demo.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.classno3_demo.R;
import com.example.classno3_demo.entity.StudentData;

import java.util.List;

/**
 * Created by lum on 2018/5/27.
 */

public class MyListAdapter extends BaseAdapter {

    private List<StudentData> mStudentDataList;   //创建一个StudentData 类的对象 集合
    private LayoutInflater inflater;

    public  MyListAdapter (List<StudentData> mStudentDataList, Context context) {
        this.mStudentDataList = mStudentDataList;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mStudentDataList == null?0:mStudentDataList.size();  //判断有说个Item
    }

    @Override
    public Object getItem(int position) {
        return mStudentDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //加载布局为一个视图
        View view = inflater.inflate(R.layout.list_item_2,null);
        StudentData mStudentData = (StudentData) getItem(position);

        //在view 视图中查找 组件
        TextView tv_name = (TextView) view.findViewById(R.id.text_name);
        TextView tv_age = (TextView) view.findViewById(R.id.text_age);
        ImageView im_photo = (ImageView) view.findViewById(R.id.phone_id);

        //为Item 里面的组件设置相应的数据
        tv_name.setText(mStudentData.getName());
        tv_age.setText("age: "+ mStudentData.getAge());
        im_photo.setImageResource(mStudentData.getPhoto());

        //返回含有数据的view
        return view;
    }
}

