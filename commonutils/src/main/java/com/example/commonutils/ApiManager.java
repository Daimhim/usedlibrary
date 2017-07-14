package com.example.commonutils;

import android.app.Application;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Project name：usedlibrary
 * Project version：com.example.commonutils
 * Creation time：2017/7/14 0014 上午 0:48
 * Founder: Daimhim
 * QQ: 154944544
 * Remarks:
 */

public class ApiManager {
    private static Application mApplications;

    //初始化
    public static void init(Application application) {
        mApplications = application;
    }

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            if (NetWorkUtil.isNetWorkAvailable(mApplications)) {
                int maxAge = 60; // 在线缓存在1分钟内可读取
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };
    private static ApiManager apiManager;
    private static File httpCacheDirectory = new File(mApplications.getCacheDir(), mApplications.getPackageName());
    //缓存大小
    private static int cacheSize = 10 * 1024 * 1024; // 10 MiB
    private static Cache cache = new Cache(httpCacheDirectory, cacheSize);
    private static OkHttpClient client = new OkHttpClient.Builder()
            .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
            .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
            .cache(cache)
            .build();

    public static ApiManager getInstence() {
        if (apiManager == null) {
            synchronized (ApiManager.class) {
                if (apiManager == null) {
                    apiManager = new ApiManager();
                }
            }
        }
        return apiManager;
    }

//    public ZhihuApi getZhihuApiService() {
//        if (zhihuApi == null) {
//            synchronized (zhihuMonitor) {
//                if (zhihuApi == null) {
//                    zhihuApi = new Retrofit.Builder()
//                            .baseUrl("http://news-at.zhihu.com")
//                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                            .client(client)
//                            .addConverterFactory(GsonConverterFactory.create())
//                            .build().create(ZhihuApi.class);
//                }
//            }
//        }
//
//        return zhihuApi;
//    }
//
//    public TopNews getTopNewsService() {
//        if (topNews == null) {
//            synchronized (zhihuMonitor) {
//                if (topNews == null) {
//                    topNews = new Retrofit.Builder()
//                            .baseUrl("http://c.m.163.com")
//                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                            .client(client)
//                            .addConverterFactory(GsonConverterFactory.create())
//                            .build().create(TopNews.class);
//
//                }
//            }
//        }
//
//        return topNews;
//    }
//
//    private GankApi ganK;
//
//    public GankApi getGankService() {
//        if (ganK == null) {
//            synchronized (zhihuMonitor) {
//                if (ganK == null) {
//                    ganK = new Retrofit.Builder()
//                            .baseUrl("http://gank.io")
//                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                            .client(client)
//                            .addConverterFactory(GsonConverterFactory.create())
//                            .build().create(GankApi.class);
//
//                }
//            }
//        }
//        return ganK;
//    }
}
