package com.example.demo.tellajoke;

import com.example.basic.BasePresenter;

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

public class TellJokePresenter extends BasePresenter<TellJokeContract.View,TellJokeModule> implements TellJokeContract.Presenter{

    public TellJokePresenter(TellJokeContract.View view, TellJokeModule module) {
        super(view, module);
    }

    @Override
    public void getJokeSet(int page,int pagesize) {
//        String key,int page,int pagesize,long titme
//        module.getJokeList("",page,pagesize,"",System.currentTimeMillis())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Joke>() {
//                    @Override
//                    public void accept(Joke joke) throws Exception {
//                        QLog.i(TAG,joke.toString());
//                    }
//                });
    }
}
