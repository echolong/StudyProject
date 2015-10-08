package com.example.study.studyproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.study.studyproject.ui.Coordinator2Activity;
import com.example.study.studyproject.ui.CustomCoordinatorActivity;
import com.example.study.studyproject.ui.ImmerseActivity;
import com.example.study.studyproject.ui.NewsDesignActivity;

public class MainActivity extends Activity {

    private String[] titleActivity = {"CustomCoordinatorActivity", "Coordinator2Activity", "NewsDesignActivity", "ImmerseActivity"};
    private ListView activityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityList = (ListView) findViewById(R.id.uiList);

        activityList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleActivity));

        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(MainActivity.this, CustomCoordinatorActivity.class);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, Coordinator2Activity.class);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, NewsDesignActivity.class);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, ImmerseActivity.class);
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
