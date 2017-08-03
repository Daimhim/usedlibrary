package com.example.basic;

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

public abstract class BasePresenter<V extends BaseContract.View,M extends BaseModule>  implements BaseContract.Presenter{
    String TAG = "TAG:" + getClass().getSimpleName();

    protected V view;
    protected M module;

    public BasePresenter(V view, M module) {
        this.view = view;
        this.module = module;
    }

    @Override
    public void onStart(){

    }

    @Override
    public void onStop() {

    }
}
