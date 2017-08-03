package com.example.demo.application;

import android.app.Application;

import com.example.commonutils.config.Config;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/2 11:14
 * 修改人：Daimhim
 * 修改时间：2017/8/2 11:14
 * 类描述：
 * 修改备注：
 */

public class StartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Config.init(this);
        init();
    }

    private void init() {
        Config.DEBUG = true;
        Config.BASE_URL = "";
    }
}
