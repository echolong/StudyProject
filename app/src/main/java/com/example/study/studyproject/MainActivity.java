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
import com.example.study.studyproject.ui.activity.CoordinatorActivity;
import com.example.study.studyproject.ui.activity.CoordinatorListViewActivity;
import com.example.study.studyproject.ui.activity.DrawerLayoutActivity;
import com.example.study.studyproject.ui.activity.LEDWatchActivity;
import com.example.study.studyproject.ui.activity.StudyActivity;
import com.example.study.studyproject.ui.activity.WeatherActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends Activity {

    private String[] titleActivity = {"CustomCoordinatorActivity", "Coordinator2Activity",
            "NewsDesignActivity", "ImmerseActivity", "MVP设计模式", "50个开发技巧",
            "LEDWatchActivity", "测试Coordinator", "测试Coordinator_ListView",
            "抽屉",};
    private ListView activityList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityList = (ListView) findViewById(R.id.uiList);

        activityList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleActivity));
        test();
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
                    case 4:
                        intent = new Intent(MainActivity.this, WeatherActivity.class);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, StudyActivity.class);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this, LEDWatchActivity.class);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this, CoordinatorActivity.class);
                        break;
                    case 8:
                        intent = new Intent(MainActivity.this, CoordinatorListViewActivity.class);
                        break;
                    case 9:
                        intent = new Intent(MainActivity.this, DrawerLayoutActivity.class);
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    private void test() {
        ArrayList<News> old = getArraylist(0, 3);
        ArrayList<News> news = getArraylist(2, 5);

        ArrayList<News> noRepeat = wipeOffRepeat(old, news);

    }

    private ArrayList<News> getArraylist(int start, int stop) {
        ArrayList<News> list = new ArrayList<>();
        for (int i = start; i < stop; i++) {
            News news = new News(i, "名称" + i);
            list.add(news);
        }
        return list;
    }

    public static ArrayList<News> wipeOffRepeat(List<News> oldNews, List<News> news) {
        int oldLength = oldNews.size();
        int newsLenght = news.size();
        Iterator<News> iterator = news.iterator();
        while (iterator.hasNext()) {
            News newsObject = iterator.next();
            for (int i = 0; i < oldLength; i++) {
                News oldNewsObject = oldNews.get(i);
                if (newsObject.getId() == oldNewsObject.getId()) {
                    iterator.remove();
                    break;
                }
            }
        }
//        for (int i = 0; i < newsLenght; i++) {
//            News newsObject = news.get(i);
//            for (int j = 0; j < oldLength; j++) {
//                News oldNewsObject = oldNews.get(j);
//                if (newsObject.getConentid() == oldNewsObject.getConentid()) {
//                    news.remove(newsObject);
//                    break;
//                }
//            }
//        }
        ArrayList<News> noRepeat = new ArrayList<>();
        noRepeat.addAll(news);
        return noRepeat;
    }

    public class News {
        private int id;
        private String name;

        public News(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
