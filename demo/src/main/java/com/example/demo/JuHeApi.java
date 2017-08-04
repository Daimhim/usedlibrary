package com.example.demo;

import android.util.Log;

import com.example.demo.bean.Joke;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 项目名称：com.example.demo
 * 项目版本：usedlibrary
 * 创建人：Daimhim
 * 创建时间：2017/8/3 15:45
 * 修改人：Daimhim
 * 修改时间：2017/8/3 15:45
 * 类描述：
 * 修改备注：
 */

public interface JuHeApi {
    @GET("joke/content/list.from?")
    Call<Joke> getJokeList(@Query("key") String key, @Query("page") int page,
                           @Query("pagesize")int pagesize, @Query("sort")String sort, @Query("time")long titme);
}
