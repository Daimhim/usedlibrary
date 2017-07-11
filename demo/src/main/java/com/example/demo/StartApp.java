package com.example.demo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/7/10 14:21
 * 修改人：Daimhim
 * 修改时间：2017/7/10 14:21
 * 类描述：
 * 修改备注：
 */

public class StartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        int pid = android.os.Process.myPid();//获取进程pid
        String processName = null;
        ActivityManager am = (ActivityManager)this.getSystemService(Context.ACTIVITY_SERVICE);//获取系统的ActivityManager服务
        for (ActivityManager.RunningAppProcessInfo appProcess : am.getRunningAppProcesses()){
            if(appProcess.pid == pid){
                processName = appProcess.processName;
                Log.i("zx_Main","StartApp"+processName);
                break;
            }
        }
    }
}
