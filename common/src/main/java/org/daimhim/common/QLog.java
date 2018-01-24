package com.example.basic.utils;

import android.util.Log;

/**
 * 项目名称：basic
 * 项目版本：1.0.0
 * 创建人：Daimhim
 * 创建时间：2017/7/21 13:56
 * 修改人：Daimhim
 * 修改时间：2017/7/21 13:56
 * 类描述：
 * 修改备注：
 */

public class QLog {
    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void v(String tag, String msg, Throwable tr) {
        Log.v(tag, msg,tr);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void d(String tag, String msg, Throwable tr) {
        Log.d(tag, msg,tr);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void i(String tag, String msg, Throwable tr) {
        Log.i(tag, msg,tr);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable tr) {
        Log.w(tag, msg,tr);
    }

    public static void w(String tag, Throwable tr) {
        Log.w(tag,tr);
    }

    public static void e(String tag, String msg) {
        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable tr) {
        Log.e(tag, msg,tr);
    }


}
