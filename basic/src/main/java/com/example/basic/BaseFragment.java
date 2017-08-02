package com.example.basic;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.basic.utils.ProgressDialogUtils;
import com.example.basic.utils.ToastUtil;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/2 14:46
 * 修改人：Daimhim
 * 修改时间：2017/8/2 14:46
 * 类描述：
 * 修改备注：
 */

public abstract class BaseFragment extends Fragment implements BaseContract.View{

    protected String TAG = "TAG:" + getClass().getSimpleName();

    protected Context mContext;


    protected ProgressDialogUtils mProgressDialogUtils;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mProgressDialogUtils = new ProgressDialogUtils();
        onSetPresenterImp();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        onSetContentView(inflater, container, savedInstanceState);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onSetUpView(view,savedInstanceState);
        onSetEntry();
    }

    @Override
    public abstract void setPresenter();

    @Override
    public void showProgressDialog() {
        mProgressDialogUtils.showProgressDialog(mContext);
    }

    @Override
    public void dissProgressDialog() {
        mProgressDialogUtils.dismissProgressDialog();
    }

    @Override
    public void showError(String error) {
        ToastUtil.showToast(mContext,error);
    }

    /**
     * 获取业务逻辑实现类
     **/
    protected abstract void onSetPresenterImp();

    /**
     * 获取布局文件
     **/
    protected abstract void onSetContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    /**
     * 初始化组件
     **/
    protected abstract void onSetUpView(View view,Bundle savedInstanceState);

    /**
     * 入口
     **/
    protected abstract void onSetEntry();

    @Override
    public void onPause() {
        super.onPause();
        dissProgressDialog();
    }
}
