package com.example.demo;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/7/10 14:15
 * 修改人：Daimhim
 * 修改时间：2017/7/10 14:15
 * 类描述：
 * 修改备注：
 */

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_tonew;
    TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_tonew = (TextView) findViewById(R.id.tv_tonew);
        tv_show = (TextView) findViewById(R.id.tv_show);
        tv_tonew.setOnClickListener(this);
        int pid = android.os.Process.myPid();//获取进程pid
        String processName = null;
        ActivityManager am = (ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);//获取系统的ActivityManager服务
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()){
            if(appProcess.pid == pid){
                processName = appProcess.processName;
                Log.i("zx_MainDemoActivity","processName:"+processName);
                break;
            }
        }
        tv_show.setText(processName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_tonew:
                Intent intent = new Intent(this,Demo2Activity.class);
                intent.putExtra("goodId","123456");
                startActivity(intent);
                break;
        }
    }
}
