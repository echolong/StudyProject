package com.example.study.studyproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.study.studyproject.R;
public class ActivityLifeActivity extends AppCompatActivity {

    public static final  String TAG = "activity_1_:";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life);

        Log.i(TAG,"onCreate");
        if(savedInstanceState != null){
            int age  = savedInstanceState.getInt("age");
            Toast.makeText(ActivityLifeActivity.this, "年龄:"+age, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 点击时间
     * @param view
     */
    public void onClick(View view){
        Intent intent = new Intent(ActivityLifeActivity.this,ActivityLife2Activity.class);
//        getApplicationContext().startActivity(intent);
        startActivity(intent);
    }

    /**
     * 异常退出
     * @param view
     */
    public void onSecondClick(View view){
//        ImageView img = (ImageView)findViewById(R.id.test_id);
////        TextView test = (TextView)findViewById(R.id.test_id);
//        test.setText("哈哈哈");

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestory");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("age",100);
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstance");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }
}
