package com.example.demo.tellajoke;

import com.example.demo.mvp.MVPBaseContract;
import com.example.demo.bean.Joke;

import java.util.List;

import io.reactivex.Observable;

/**
 * 项目名称：com.example.demo.tellajoke
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/4 9:29
 * 修改人：Daimhim
 * 修改时间：2017/8/4 9:29
 * 类描述：
 * 修改备注：
 */

public interface TellJokeContract {
    interface View extends MVPBaseContract.View{
        void setValue(List<Joke.ResultBean.DataBean> beanList);
    }

    interface Presenter extends MVPBaseContract.Presenter{
        void getJokeSet(int page,int pagesize);
    }

    public interface Module extends MVPBaseContract.Module{
        Observable<Joke> getJokeList(String key, int page, int pagesize, String sort, long titme);
    }
}
