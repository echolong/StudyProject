package com.example.study.studyproject.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.study.studyproject.R;
import com.example.study.studyproject.ui.view.DividerItemDecoration;

import java.util.ArrayList;

public class CoordinatorActivity extends Activity {

    private RecyclerView dataList;
    private CollapsingToolbarLayout collapsingToolbar;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "测试数据", Snackbar.LENGTH_LONG).setAction("bb", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(CoordinatorActivity.this, "aa", Toast.LENGTH_SHORT).show();
                    }
                }).show();

            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //设置工具栏标题
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //设置标题
        collapsingToolbar.setTitle("cheeseName");
        //设置缩小后的背景颜色
        collapsingToolbar.setContentScrimResource(R.color.data_bg);

        dataList = (RecyclerView) findViewById(R.id.listView);
        TestRecycleAdapter adapter = new TestRecycleAdapter(getStringDate(20));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        dataList.setLayoutManager(manager);
        dataList.setItemAnimator(new DefaultItemAnimator());
        dataList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        dataList.setAdapter(adapter);
    }


    private ArrayList<TestData> getStringDate(int num) {
        ArrayList<TestData> test = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TestData data = new TestData();
            data.setTestString("测试数据" + i);
            test.add(data);
        }
        return test;
    }

    public class TestRecycleAdapter extends RecyclerView.Adapter {

        private ArrayList<TestData> arrayList;

        public TestRecycleAdapter(ArrayList<TestData> list) {
            this.arrayList = list;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.coordinator_item, parent, false);
            return new TestRecycleHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            TestRecycleHolder testRecycleHolder = (TestRecycleHolder) holder;
            testRecycleHolder.fillData(arrayList.get(position));
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    public class TestRecycleHolder extends RecyclerView.ViewHolder {

        private TextView testView;

        public TestRecycleHolder(View itemView) {
            super(itemView);
            testView = (TextView) itemView.findViewById(R.id.testId);
        }

        public void fillData(TestData data) {
            testView.setText(data.getTestString());
        }
    }

    public class TestData {
        private String testString;

        public String getTestString() {
            return testString;
        }

        public void setTestString(String testString) {
            this.testString = testString;
        }
    }
}
