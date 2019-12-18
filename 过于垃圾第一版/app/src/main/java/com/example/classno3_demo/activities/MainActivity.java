package com.example.classno3_demo.activities;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.classno3_demo.fragment.DemoFragment;
import com.example.classno3_demo.fragment.MyFragment;
import com.example.classno3_demo.R;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView_1;
    private TextView textView_2;
    private TextView textView_3;
    private TextView textView_top_bar;
    private FrameLayout ly_content;
    private MyFragment f1,f2,f3;
    private DemoFragment fDemo;
    private FragmentManager fragmentManager;
    private int[] scores=new int[]{89,-23,64,91,119,52,73};//创建scores数组
    private int[] arr=new int[3];//创建一个容量为3的数组用来接收返回的三个数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//设置不显示topbar
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        bindView();
        textView_1.performClick();
    }

    //UI组件初始化与事件绑定
    private void bindView() {
        textView_1= findViewById(R.id.text_1);
        textView_2=findViewById(R.id.text_2);
        textView_3=findViewById(R.id.text_3);
        textView_top_bar=findViewById(R.id.text_top_bar);
        ly_content=findViewById(R.id.ly_content);

        textView_1.setOnClickListener(this);
        textView_2.setOnClickListener(this);
        textView_3.setOnClickListener(this);
        textView_top_bar.setOnClickListener(this);
    }
    //重置所有文本的选中状态
    private void setSelected(){
        textView_1.setSelected(false);
        textView_2.setSelected(false);
        textView_3.setSelected(false);
        textView_top_bar.setSelected(false);
    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(f1!=null)fragmentTransaction.hide(f1);
        if(f2!=null)fragmentTransaction.hide(f2);
        if(f3!=null)fragmentTransaction.hide(f3);
        if(fDemo!=null)fragmentTransaction.hide(fDemo);
    }
    /**
     * ClassNo.2 level_2*/
    //编写一个方法返回要输出的9*9乘法表
    private String doubleNine(){
        String doublenine="";
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                doublenine=doublenine+i+"*"+j+"="+i*j+"\t";
            }
            doublenine=doublenine+"\n";
        }
        return doublenine;
    }
    /**
     * ClassNo.2 level_3*/
    //编写一个方法对数组进行排序返回前三个
    private int[] mysort(int[] inarr){
        int a=0;
        Arrays.sort(inarr);
        for(int i=inarr.length-1;i>=0;i--){
            if (inarr[i] > 0 && inarr[i] < 100) {
                arr[a] = inarr[i];
                a++;
                if(a==3)
                    return arr;
            }
        }
        return arr;
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (view.getId()){
            case R.id.text_1:
                setSelected();
                textView_1.setSelected(true);
                textView_top_bar.setText("9*9乘法表");
//                if(f1==null){
//                    f1=new MyFragment("消息");
//                    fragmentTransaction.add(R.id.ly_content,f1);
//                }else {
//                    fragmentTransaction.show(f1);
//                }

                //输出9*9乘法表的fragment
                if(f1==null){
                    f1=new MyFragment(doubleNine());//调用方法
                    fragmentTransaction.add(R.id.ly_content,f1);
                }else {
                    fragmentTransaction.show(f1);
                }
                break;
            case R.id.text_2:
                setSelected();
                textView_2.setSelected(true);
                textView_top_bar.setText("排序输出");
                if(f2==null){
                    f2=new MyFragment("考试成绩的前三名为\n"+mysort(scores)[0]+"\n"+mysort(scores)[1]+"\n"+mysort(scores)[2]);//调用mysort
                    fragmentTransaction.add(R.id.ly_content,f2);
                }else {
                    fragmentTransaction.show(f2);
                }
                break;
            case R.id.text_3:
                setSelected();
                textView_3.setSelected(true);
                textView_top_bar.setText("FragmentDemo");
                if(fDemo==null){
                    fDemo=new DemoFragment();
                    fragmentTransaction.add(R.id.ly_content,fDemo);
                }else {
                    fragmentTransaction.show(fDemo);
                }
                break;
        }
        fragmentTransaction.commit();

    }
}
