package com.bob.retrofit.adapter.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 基类适配器
 * Created by bob on 2015/11/2.
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter<BindingHolder> {

    private List<T> mList = new ArrayList<>();
    protected OnItemClickListener<T> onItemClickListener;

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getConvertView(viewType), parent, false);
        BindingHolder holder = new BindingHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClickListener(getItem(position));
            }
        });
        onBind(holder, position);
    }

    public abstract void onBind(BindingHolder holder, int position);

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public T getItem(int position) {
        return mList.get(position);
    }

    public void appentList(List<T> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public void replaceList(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        mList = list;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public abstract int getConvertView(int viewType);

    public interface OnItemClickListener<T> {
        void onItemClickListener(T t);
    }

}
