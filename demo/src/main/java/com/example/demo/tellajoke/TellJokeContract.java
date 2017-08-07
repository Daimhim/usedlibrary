package com.example.demo.tellajoke;

import com.example.basic.BaseContract;
import com.example.demo.bean.Joke;

import java.util.List;

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
    interface View extends BaseContract.View{
        void setValue(List<Joke.ResultBean.DataBean> beanList);
    }

    interface Presenter extends BaseContract.Presenter{
        void getJokeSet(int page,int pagesize);
    }
}
