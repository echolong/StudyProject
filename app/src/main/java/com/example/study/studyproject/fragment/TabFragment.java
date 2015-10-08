package com.example.study.studyproject.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.study.studyproject.R;
import com.example.study.studyproject.adapter.TabRecyclerAdapter;
import com.example.study.studyproject.obj.ImageInfoObject;

import java.util.ArrayList;

/**
 * Description:
 * User: xjp
 * Date: 2015/6/15
 * Time: 15:03
 */

public class TabFragment extends Fragment {

    private String content;
    private View view;
    private RecyclerView recyclerView;

    private ArrayList<ImageInfoObject> list;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycler_item, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        content = getArguments().getString("content");
        recyclerView = (RecyclerView) view.findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        initData();
    }


    private void initData() {

        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ImageInfoObject object = new ImageInfoObject(R.mipmap.top_image, "标题" + i);
            list.add(object);
        }

        TabRecyclerAdapter adapter = new TabRecyclerAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}