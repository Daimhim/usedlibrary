package com.example.commonutils.clouddata;

import android.util.Log;

import com.example.commonutils.config.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.commonutils.config.Config.BASE_URL;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2017/2/13
 */

public class APIRetrofit {
    static String TAG = "APIRetrofit";
    private static Retrofit sRetrofit;

    private static OkHttpClient sOKHttpClient;

    private static CacheInterceptor cacheInterceptor = new CacheInterceptor();

    private static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static <T> T createApi(Class<T> clazz) {
        return getInstance().create(clazz);
    }

    public static <T> T createApi(Class<T> clazz, String url) {
        return getInstance(url).create(clazz);
    }

    public static Retrofit getInstance() {
        if (sRetrofit == null) {
            synchronized (APIRetrofit.class) {
                if (sRetrofit == null) {
                    sRetrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(getsOKHttpClient())
                            .build();

                }
            }
        }
        return sRetrofit;
    }

    public static Retrofit getInstance(String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getsOKHttpClient())
                .build();
    }

    public static OkHttpClient getsOKHttpClient() {
        if (sOKHttpClient == null) {
            synchronized (APIRetrofit.class) {
                if (sOKHttpClient == null) {
                    sOKHttpClient = new OkHttpClient.Builder()
                            .retryOnConnectionFailure(Config.RETRY_ON_CONNECTION_FAILURE)  //方法为设置出现错误进行重新连接。
                            .cache(HttpCache.getCache())  //缓存
                            //设置Cache
                            .addNetworkInterceptor(cacheInterceptor)//缓存方面需要加入这个拦截器
                            .addInterceptor(cacheInterceptor)
                            .connectTimeout(Config.CONNECT_TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(Config.READ_TIME_OUT, TimeUnit.SECONDS)
                            .writeTimeout(Config.WRITE_TIME_OUT, TimeUnit.SECONDS)
                            //打印日志
                            .addInterceptor(interceptor)
                            .build();
                }
            }
        }

        return sOKHttpClient;
    }



}
