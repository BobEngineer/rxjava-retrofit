package com.bob.retrofit.request;

import com.bob.retrofit.entity.LatestNews;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by bob on 2016/5/25.
 */
public interface NewsService {

    @GET("4/news/latest")
    Observable<LatestNews> getLatestNews();

    @GET("4/news/{id}")
    Observable<LatestNews> getNewsInfo(@Path("id") int id);
}
