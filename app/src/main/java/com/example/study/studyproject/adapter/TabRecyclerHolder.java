package com.example.study.studyproject.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.study.studyproject.R;
import com.example.study.studyproject.obj.ImageInfoObject;

/**
 * @autho：liuyulong on 2015/9/24 15:38
 */
public class TabRecyclerHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView imageText;

    public TabRecyclerHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageText = (TextView) itemView.findViewById(R.id.imageText);
    }

    public void fillData(ImageInfoObject obj) {
        imageView.setImageResource(obj.getInfoSource());
        imageText.setText(obj.getInfoText());
    }
}
