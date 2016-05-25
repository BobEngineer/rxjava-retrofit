package com.bob.retrofit.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.bob.retrofit.BR;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by bob on 2016/5/25.
 */
public class Story extends BaseObservable{

    private int id;

    private String title;

    @SerializedName("ga_prefix")
    private String  gaPrefix;

    private List<String> images;

    private String image;

    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public String getGaPrefix() {
        return gaPrefix;
    }

    public void setGaPrefix(String gaPrefix) {
        this.gaPrefix = gaPrefix;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
