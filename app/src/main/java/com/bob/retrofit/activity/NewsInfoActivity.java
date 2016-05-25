package com.bob.retrofit.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bob.retrofit.request.NewsService;
import com.bob.retrofit.util.RetrofitUtil;

import retrofit2.Retrofit;

/**
 * 新闻详情
 * Created by bob on 2016/5/25.
 */
public class NewsInfoActivity extends AppCompatActivity {

    private static final String EXTRA_ID = "extra_id";

    public static Intent makeIntent(Context context, int id) {
        return new Intent(context, NewsInfoActivity.class).putExtra(EXTRA_ID, id);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getNewsInfo() {
        int id = getIntent().getIntExtra(EXTRA_ID, 0);
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        NewsService newsService = retrofit.create(NewsService.class);
        newsService.getNewsInfo(id);
    }
}
