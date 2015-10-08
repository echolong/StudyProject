package com.example.study.studyproject.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.study.studyproject.R;

public class GlideImageActivity extends AppCompatActivity {

    private String strUrl = "http://i6.topit.me/6/5d/45/1131907198420455d6o.jpg";
    private ImageView imageView;
    private Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_image);
        imageView = (ImageView) findViewById(R.id.glideImage);
        startBtn = (Button) findViewById(R.id.startBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(GlideImageActivity.this).load(strUrl).into(imageView);
            }
        });
    }


}
