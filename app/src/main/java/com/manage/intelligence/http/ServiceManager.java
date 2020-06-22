package com.manage.intelligence.http;

import android.app.Application;
import android.content.Context;

import com.manage.intelligence.exception.NoNetworkException;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author: XuChi
 * @version: V1.0
 * @project: xcf_user_new
 * @package: io.cxc.user.manager
 * @description: Retrofit Service管理器
 * @date: 2019/8/13
 * @time: 17:45
 */
public class ServiceManager {
    private static ServiceManager instance;

    private LiveNetworkMonitor networkMonitor;

    /**
     * 超时时间
     */
    public static final int DEFAULT_TIMEOUT = 10;

    private ServiceManager() {

    }

    public static ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }

        return instance;
    }

    public <T> T getService(Class<T> t, Context context) {
        return getService("http://39.100.40.204:8088/", t, context);
    }

    public <T> T getService(String baseUrl, Class<T> t, Context context) {
        networkMonitor = new LiveNetworkMonitor(context);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                /*.addInterceptor(new RequestInterceptor(context)).addInterceptor(new
                        LoggerInterceptor(context)).addInterceptor(chain -> {
                    boolean connected = networkMonitor.isConnected();
                    if (networkMonitor.isConnected()) {
                        return chain.proceed(chain.request());
                    } else {
                        throw new NoNetworkException();
                    }

                })*/;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(builder.build())
                .addConverterFactory(MyGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(t);
    }
}
