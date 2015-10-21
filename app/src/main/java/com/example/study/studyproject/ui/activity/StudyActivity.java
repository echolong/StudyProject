package com.example.study.studyproject.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.study.studyproject.R;

public class StudyActivity extends AppCompatActivity {

    private TextView linkText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);

        linkText = (TextView)findViewById(R.id.link_text);
        linkText.setText(Html.fromHtml(getString(R.string.text_link)));
        linkText.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
