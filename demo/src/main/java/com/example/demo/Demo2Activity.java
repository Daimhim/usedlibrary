package com.example.demo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/7/10 14:43
 * 修改人：Daimhim
 * 修改时间：2017/7/10 14:43
 * 类描述：
 * 修改备注：
 */

public class Demo2Activity extends AppCompatActivity {

    TextView tv_tonew;
    TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_tonew = (TextView) findViewById(R.id.tv_tonew);
        tv_show = (TextView) findViewById(R.id.tv_show);
        int pid = android.os.Process.myPid();//获取进程pid
        String processName = null;
        ActivityManager am = (ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);//获取系统的ActivityManager服务
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()){
            if(appProcess.pid == pid){
                processName = appProcess.processName;
                Log.i("zx_MainDemo2Activity","processName:"+processName);
                break;
            }
        }
        tv_show.setText(processName+getIntent().getStringExtra("goodId"));
    }
}
