package com.example.study.studyproject.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.study.studyproject.R;
import com.example.study.studyproject.ui.view.DividerItemDecoration;

import java.util.ArrayList;

public class CoordinatorActivity extends Activity {

    private RecyclerView dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator);

        //设置工具栏标题
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("cheeseName");

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
