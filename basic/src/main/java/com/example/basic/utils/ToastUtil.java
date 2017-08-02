package com.example.basic.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ToastUtil {
    private static Toast mToast;

    /**
     * 显示short message
     * @param context 全局context
     * @param resId string string资源id
     */
    public static void showToast(Context context, int resId) {
        if(mToast == null) {
            mToast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(resId);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    /**
     * 显示short message
     * @param context 全局context
     * @param message 显示msg
     */
    public static void showToast(Context context, String message) {
        if(mToast == null) {
            mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(message);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }
}
