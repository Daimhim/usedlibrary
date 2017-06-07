package com.example.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.used.view.RadioGroupFlowLayout;
import com.example.xuyuan.adapter.BaseAdaptyer;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new BaseAdaptyer();
        new RadioGroupFlowLayout(this);
    }
}
