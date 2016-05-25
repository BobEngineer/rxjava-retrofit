package com.bob.retrofit.adapter.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bob on 2015/11/6.
 */
public class BindingHolder extends RecyclerView.ViewHolder{
    private ViewDataBinding binding;
    public BindingHolder(View itemView) {
        super(itemView);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void setBinding(ViewDataBinding binding) {
        this.binding = binding;
    }
}
