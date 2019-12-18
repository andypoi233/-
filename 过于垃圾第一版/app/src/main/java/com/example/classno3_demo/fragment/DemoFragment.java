package com.example.classno3_demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.classno3_demo.R;
import com.example.classno3_demo.activities.ListViewDemoActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoFragment extends Fragment implements View.OnClickListener {

    private Button button_1;

    public DemoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_demo,container,false);
        button_1=view.findViewById(R.id.button_1);
        button_1.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Date date=new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年mm月dd日 hh:mm:ss");
        switch (view.getId()){
            case R.id.button_1:
//                Toast.makeText(getActivity(),"你点击了第个",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getActivity(), ListViewDemoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
