package com.bob.retrofit.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bob.retrofit.R;
import com.bob.retrofit.adapter.StoryAdapter;
import com.bob.retrofit.databinding.ActivityMainBinding;
import com.bob.retrofit.entity.LatestNews;
import com.bob.retrofit.request.StoryService;
import com.bob.retrofit.util.RetrofitUtil;

import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private StoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        binding.recyclerView.setLayoutManager(manager);
        adapter = new StoryAdapter();
        binding.recyclerView.setAdapter(adapter);
        getStories();
    }

    private void getStories() {
        Retrofit retrofit = RetrofitUtil.getInstance().getRetrofit();
        StoryService storyService = retrofit.create(StoryService.class);
        Observable<LatestNews> observable = storyService.getLatestNews();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LatestNews>() {
                    @Override
                    public void call(LatestNews latestNews) {
                        adapter.replaceList(latestNews.getStories());
                    }
                });
    }
}
