package com.example.demo.tellajoke;

import com.example.demo.mvp.MVPBasePresenter;
import com.example.demo.bean.Joke;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名称：com.example.demo.tellajoke
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/4 9:28
 * 修改人：Daimhim
 * 修改时间：2017/8/4 9:28
 * 类描述：
 * 修改备注：
 */

public class TellJokePresenterMVP extends MVPBasePresenter<TellJokeContract.View,TellJokeContract.Module> implements TellJokeContract.Presenter{

    public TellJokePresenterMVP(TellJokeContract.View view, TellJokeContract.Module module) {
        super(view, module);
    }

    @Override
    public void getJokeSet(int page,int pagesize) {
        view.showProgressDialog();
//        String key,int page,int pagesize,long titme

//        module.getJokeList("6a7f40ff902220aead73f5f746d423f1", page, pagesize, "", System.currentTimeMillis());
        module.getJokeList("6a7f40ff902220aead73f5f746d423f1",page,pagesize,"",(int)(System.currentTimeMillis()/1000))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Joke>() {
                    @Override
                    public void accept(Joke joke) throws Exception {
                        view.setValue(joke.getResult().getData());
                        view.dissProgressDialog();
//                        QLog.i(TAG,joke.toString());
                    }
                });
    }
}
