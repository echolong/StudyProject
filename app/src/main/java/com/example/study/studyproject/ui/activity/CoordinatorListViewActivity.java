package com.example.study.studyproject.ui.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.example.study.studyproject.R;

public class CoordinatorListViewActivity extends Activity {

    private AbsListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_list_view);
        listView = (AbsListView) findViewById(R.id.listView);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listView.setNestedScrollingEnabled(true);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getTestDate(20));
        listView.setAdapter(adapter);
    }

    private String[] getTestDate(int num) {
        String[] strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = "测试数据" + i;
        }
        return strings;
    }
}
