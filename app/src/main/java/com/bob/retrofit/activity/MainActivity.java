package com.bob.retrofit.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bob.retrofit.R;
import com.bob.retrofit.adapter.StoryAdapter;
import com.bob.retrofit.databinding.ActivityMainBinding;
import com.bob.retrofit.entity.LatestNews;
import com.bob.retrofit.request.NewsService;
import com.bob.retrofit.util.RetrofitUtil;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(manager);
        adapter = new StoryAdapter();
        adapter.setOnItemClickListener(story -> startActivity(NewsInfoActivity.makeIntent(MainActivity.this,story.getId())));
        binding.recyclerView.setAdapter(adapter);
        getStories();
    }

    private void getStories() {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        NewsService newsService = retrofit.create(NewsService.class);
        Observable<LatestNews> observable = newsService.getLatestNews();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(latestNews -> {
                    adapter.replaceList(latestNews.getStories());
                });
    }
}
