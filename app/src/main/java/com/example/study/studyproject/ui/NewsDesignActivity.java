package com.example.study.studyproject.ui;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.study.studyproject.R;

public class NewsDesignActivity extends AppCompatActivity {

    private TextInputLayout textLayout;
    private TextInputLayout textLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_design);

        textLayout = (TextInputLayout) findViewById(R.id.textLayout);
        textLayout.setHint("请输入信息");

        final EditText editText = textLayout.getEditText();
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    textLayout.setErrorEnabled(true);
                    textLayout.setError("姓名长度不能超过4个");
                    editText.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_ATOP);
                } else {
                    textLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        textLayout2 = (TextInputLayout) findViewById(R.id.textLayout2);
        textLayout2.setHint("请输入信息");
        EditText editText2 = textLayout2.getEditText();
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    textLayout2.setErrorEnabled(true);
                    textLayout2.setError("姓名长度不能超过4个");
                } else {
                    textLayout2.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
