package com.bob.retrofit.util;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retorfit tool
 * Created by bob on 2016/3/29.
 */
public class RetrofitUtil {
    private static final String BASE_URL = "http://news-at.zhihu.com/api/";
    private Retrofit retrofit;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private static class SingletonHolder {
        private static final RetrofitUtil INSTANCE = new RetrofitUtil();
    }

    public static RetrofitUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private OkHttpClient createClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient client = httpClient.build();
        return client;
    }


}
