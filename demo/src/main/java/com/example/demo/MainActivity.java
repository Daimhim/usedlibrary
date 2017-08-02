package com.example.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.basic.BaseActivity;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    Button mButton;
    @Override
    protected void onSetPresenterImp() {
    }

    @Override
    protected void onSetContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSetUpView(Bundle savedInstanceState) {
        mButton = findViewById(R.id.bt_show);
        mButton.setOnClickListener(this);
    }

    @Override
    protected void onSetEntry() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_show:
                break;
        }
    }
}
