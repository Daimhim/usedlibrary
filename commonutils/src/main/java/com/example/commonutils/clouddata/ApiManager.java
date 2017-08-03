package com.example.commonutils.clouddata;



import java.io.IOException;
import java.util.concurrent.TimeUnit;


import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Project name：usedlibrary
 * Project version：com.example.commonutils
 * Creation time：2017/7/14 0014 上午 0:48
 * Founder: Daimhim
 * QQ: 154944544
 * Remarks:
 */

public class ApiManager {

    static String  TAG = "ApiManager";

    static Interceptor mTokenInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            if (TAG == null || alreadyHasAuthorizationHeader(originalRequest)) {
                return chain.proceed(originalRequest);
            }
            Request authorised = originalRequest.newBuilder()
                    .header("Authorization", TAG)
                    .build();
            return chain.proceed(authorised);
        }

        private boolean alreadyHasAuthorizationHeader(Request originalRequest) {
            return false;
        }
    };
    static Authenticator mAuthenticator = new Authenticator() {
        @Override
        public Request authenticate(Route route, Response response)
                throws IOException {
            return response.request().newBuilder()
                    .addHeader("Authorization", TAG)
                    .build();
        }
    };
    static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    static void init() {
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    static final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(interceptor)   //添加拦截器
            .retryOnConnectionFailure(true)  //方法为设置出现错误进行重新连接。
            .connectTimeout(15, TimeUnit.SECONDS)  //设置超时时间
            .cache(HttpCache.getCache())  //缓存
            .addNetworkInterceptor(mTokenInterceptor)   //缓存方面需要加入这个拦截器 让所有网络请求都附上你的拦截器，我这里设置了一个 token 拦截器，就是在所有网络请求的 header 加上 token 参数，下面会稍微讲一下这个内容。
            .authenticator(mAuthenticator) //然后，对于以上的两个拦截器，分别使用 OkHttpClient.Builder 对象的 addNetworkInterceptor(mTokenInterceptor) 和 authenticator(mAuthenticator) 即可。
//                .writeTimeout(TIMEOUT_READ, TimeUnit.SECONDS)  //写超时
//                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
//                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)  //连接超时
            .build();

    public static <T> T createApi(Class<T> clazz, String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}
