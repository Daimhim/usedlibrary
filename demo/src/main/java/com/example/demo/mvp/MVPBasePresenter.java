package com.example.demo.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

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

public abstract class MVPBasePresenter<V extends MVPBaseContract.View,M extends MVPBaseContract.Module>  implements MVPBaseContract.Presenter{
    protected String TAG = "TAG:" + getClass().getSimpleName();

    private CompositeDisposable mCompositeSubscription;
    protected V view;
    protected M module;

    public MVPBasePresenter(V view, M module) {
        this.view = view;
        this.module = module;
    }

    @Override
    public void onStart(){

    }

    @Override
    public void onStop() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.dispose();
        }
    }

    protected void addSubscription(Disposable s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeDisposable();
        }
        this.mCompositeSubscription.add(s);
    }
}
