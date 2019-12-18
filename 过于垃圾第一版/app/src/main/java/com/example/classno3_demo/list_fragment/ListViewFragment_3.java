package com.example.classno3_demo.list_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.ListFragment;

import com.example.classno3_demo.R;
import com.example.classno3_demo.entity.StudentData;
import com.example.classno3_demo.utils.MyListAdapter;

import java.util.ArrayList;
import java.util.List;
//在fragment中显示ListView要继承ListFragment
public class ListViewFragment_3 extends ListFragment {

    private ListView listView;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.listview_demo_3,container,false);
        //找到listview 组件
        listView=view.findViewById(android.R.id.list);

        List<StudentData> mStudentDataList = new ArrayList<>();  //创建studentData 对象集合
        for( int i = 1; i <= 18 ; i++) {
            StudentData mStudentData = new StudentData();      //循环创建studentData 对象
            mStudentData.setName("lum " + i + " 号");          //为对象设置姓名
            mStudentData.setAge(i);                             //为对象设置 年龄
            mStudentData.setPhoto(R.mipmap.p);              //为对象设置照片
            mStudentDataList.add(mStudentData);                  //将对象添加到列表中
        }
        //创建Adapter 实例化对象， 调用构造函数传参，将数据和adapter  绑定
        MyListAdapter mMyListAdapter = new MyListAdapter(mStudentDataList,getContext());
        listView.setAdapter(mMyListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onListItemClick(listView,view,position,id);
            }
        });//将定义的adapter 和 listView 绑定

        return view;
    }
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
        Toast.makeText(getActivity(),"你点击了第"+position+"个",Toast.LENGTH_LONG).show();
    }
}
