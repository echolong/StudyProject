package com.example.study.studyproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.study.studyproject.R;
import com.example.study.studyproject.obj.ImageInfoObject;

import java.util.ArrayList;

/**
 * @autho：liuyulong on 2015/9/24 15:36
 */
public class TabRecyclerAdapter extends RecyclerView.Adapter {

    private ArrayList<ImageInfoObject> imageList;

    public TabRecyclerAdapter(ArrayList<ImageInfoObject> list) {
        imageList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item_holder, null);
        return new TabRecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ImageInfoObject object = imageList.get(i);
        TabRecyclerHolder holder = (TabRecyclerHolder) viewHolder;
        holder.fillData(object);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }
}
