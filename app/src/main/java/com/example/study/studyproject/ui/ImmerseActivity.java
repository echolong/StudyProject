package com.example.study.studyproject.ui;

import android.os.Bundle;

import com.example.study.studyproject.R;

public class ImmerseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immerse);
        setImmerse(findViewById(R.id.content_layout));
    }
}
