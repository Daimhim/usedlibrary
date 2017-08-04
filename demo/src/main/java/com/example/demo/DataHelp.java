package com.example.demo;

import com.example.commonutils.clouddata.APIRetrofit;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/3 15:28
 * 修改人：Daimhim
 * 修改时间：2017/8/3 15:28
 * 类描述：
 * 修改备注：
 */

public class DataHelp {
    public static JuHeApi getJuHeApi(String url){
        return APIRetrofit.getInstance(url).create(JuHeApi.class);
    }
}
