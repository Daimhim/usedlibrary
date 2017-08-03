package com.example.basic;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.basic.utils.KeyboardUtils;
import com.example.basic.utils.ProgressDialogUtils;

/**
 * 项目名称：com.example.demo.welcome
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/2 14:39
 * 修改人：Daimhim
 * 修改时间：2017/8/2 14:39
 * 类描述：
 * 修改备注：
 */

public abstract class BaseActivity<P extends BaseContract.Presenter,M extends BaseModule> extends AppCompatActivity {

    protected String TAG = "TAG:" + getClass().getSimpleName();

    protected Context mContext;

    protected P presenter;

    protected M module;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setPresenterAndModule();
        onSetContentView();
        onSetUpView(savedInstanceState);
        onSetEntry();
    }
    /**
     * 获取业务逻辑实现类
     **/
    protected abstract void setPresenterAndModule();

    /**
     * 获取布局文件
     **/
    protected abstract void onSetContentView();

    /**
     * 初始化组件
     **/
    protected abstract void onSetUpView(Bundle savedInstanceState);

    /**
     * 入口
     **/
    protected abstract void onSetEntry();

    /**
     * activity finish
     **/
    protected void finishActivity() {
        KeyboardUtils.hideKeywordMethod(this);
        finish();
    }

}
