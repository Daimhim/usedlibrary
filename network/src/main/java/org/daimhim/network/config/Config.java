package org.daimhim.network.config;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 项目名称：com.example.commonutils.config
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/3 14:31
 * 修改人：Daimhim
 * 修改时间：2017/8/3 14:31
 * 类描述：
 * 修改备注：
 */

public class Config {

    public static boolean DEBUG = true;

    public static Application application;

    public static String BASE_URL;
    /**
     * 版本
     **/
    public static String CONFIG_VCODE;

    public static int CONNECT_TIME_OUT = 0;
    public static int READ_TIME_OUT = 0;
    public static int WRITE_TIME_OUT = 0;

    public static final int HTTP_RESPONSE_DISK_CACHE_MAX_SIZE = 50 * 1024 * 1024;
    public static boolean RETRY_ON_CONNECTION_FAILURE = true;

    public static void init(Application app){
        application = app;
        // 获取packagemanager的实例
        PackageManager packageManager = application.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(application.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (null != packInfo) {
            CONFIG_VCODE = packInfo.versionName;
        }
    }
}
