package com.bob.retrofit.request;

import com.bob.retrofit.entity.LatestNews;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by bob on 2016/5/25.
 */
public interface StoryService {

    @GET("4/news/latest")
    Observable<LatestNews> getLatestNews();
}
