package com.bob.retrofit.adapter;

import com.bob.retrofit.R;
import com.bob.retrofit.adapter.base.BaseAdapter;
import com.bob.retrofit.adapter.base.BindingHolder;
import com.bob.retrofit.databinding.ItemStoryBinding;
import com.bob.retrofit.entity.Story;
import com.bumptech.glide.Glide;

/**
 * Created by bob on 2016/5/25.
 */
public class StoryAdapter extends BaseAdapter<Story> {
    @Override
    public void onBind(BindingHolder holder, int position) {
        ItemStoryBinding binding = (ItemStoryBinding) holder.getBinding();
        binding.cardView.setUseCompatPadding(true);
        Story story = getItem(position);
        if (story.getImages() != null && !story.getImages().isEmpty()) {
            Glide.with(binding.getRoot().getContext()).load(story.getImages().get(0)).into(binding.image);
        }
        binding.setStory(story);
        binding.executePendingBindings();
    }

    @Override
    public int getConvertView(int viewType) {
        return R.layout.item_story;
    }
}
