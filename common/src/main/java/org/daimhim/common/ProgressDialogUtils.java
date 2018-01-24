package com.example.basic.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * 项目名称：com.meyki.chat.utils
 * 项目版本：meykichat-v1.0.0
 * 创建人：Daimhim
 * 创建时间：2017/7/24 11:16
 * 修改人：Daimhim
 * 修改时间：2017/7/24 11:16
 * 类描述：
 * 修改备注：
 */

public class ProgressDialogUtils {

    private ProgressDialog progressShow;

    public void showProgressDialog(Context context) {
        showProgressDialog(context,"正在加载...");
    }

    public void showProgressDialog(Context context, String content) {
        if (context == null) return;
        if (progressShow == null) {
            progressShow = new ProgressDialog(context);
            progressShow.setCanceledOnTouchOutside(false);
            progressShow.setOnCancelListener(new DialogInterface.OnCancelListener() {

                @Override
                public void onCancel(DialogInterface dialog) {
                    dismissProgressDialog();
                }
            });
        }
        progressShow.setMessage(content);
        progressShow.show();
    }

    public void dismissProgressDialog() {
        if (isShow()) {
            progressShow.dismiss();
        }
    }
    public boolean isShow(){
        if (null == progressShow)return false;
        return progressShow.isShowing();
    }
}
