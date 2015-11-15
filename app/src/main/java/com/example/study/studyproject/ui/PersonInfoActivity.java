package com.example.study.studyproject.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.study.studyproject.R;
import com.example.study.studyproject.bean.PersonInfoBean;
import com.example.study.studyproject.presenter.InfoPresenter;
import com.example.study.studyproject.ui.inter.IinfoView;
import com.google.gson.Gson;

public class PersonInfoActivity extends Activity implements IinfoView {

    private InfoPresenter infoPresenter;
    private EditText nameText;
    private EditText ageText;
    private EditText infoText;
    private TextView allInfoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        infoPresenter = new InfoPresenter(this);
        nameText = (EditText)findViewById(R.id.name_text);
        ageText = (EditText)findViewById(R.id.age_text);
        infoText = (EditText)findViewById(R.id.info_text);
        allInfoText = (TextView)findViewById(R.id.person_info_text);
    }

    @Override
    public void setInfo(PersonInfoBean info) {
        if(info != null){
            nameText.setText(info.getName());
            ageText.setText(String.valueOf(info.getAge()));
            infoText.setText(info.getInfo());
            Gson gson = new Gson();
            String infoStr = gson.toJson(info);
            allInfoText.setText(infoStr);
        }
    }

    @Override
    public PersonInfoBean getInfo() {
        PersonInfoBean infoBean = new PersonInfoBean();
        infoBean.setName(nameText.getText().toString());
        infoBean.setAge(Integer.valueOf(ageText.getText().toString()));
        infoBean.setInfo(infoText.getText().toString());
        return infoBean;
    }

    public void onSubmitClick(View view){
        infoPresenter.setInfo();
    }
    public void onGetClick(View view){
        infoPresenter.getInfo();
    }
}
