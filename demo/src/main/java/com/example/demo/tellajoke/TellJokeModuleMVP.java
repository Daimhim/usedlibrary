package com.example.demo.tellajoke;

import com.example.demo.mvp.MVPBaseModule;
import com.example.commonutils.clouddata.APIRetrofit;
import com.example.demo.JuHeApi;
import com.example.demo.bean.Joke;

import io.reactivex.Observable;

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

public class TellJokeModuleMVP implements MVPBaseModule {

    JuHeApi juHeApi = APIRetrofit.getInstance("http://japi.juhe.cn/").create(JuHeApi.class);
    Observable<Joke> getJokeList(String key, int page, int pagesize, String sort, long titme){

        return juHeApi.getJokeList(key, page, pagesize,sort, titme);
    }
}
