package com.bob.retrofit.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bob on 2016/5/25.
 */
public class LatestNews {

    private String date;

    private List<Story> stories;

    @SerializedName("top_stories")
    private List<Story> topStories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<Story> getTopStories() {
        return topStories;
    }

    public void setTopStories(List<Story> topStories) {
        this.topStories = topStories;
    }
}
