package com.example.study.studyproject.model;

import com.example.study.studyproject.bean.PersonInfoBean;
import com.example.study.studyproject.util.CommonUtil;
import com.example.study.studyproject.util.KEY;
import com.example.study.studyproject.util.SharedPreferencesManager;
import com.google.gson.Gson;

/**
 * Created by liuyulong on 15/11/14.
 */
public class InfoModelImpl implements InfoModel {

    private Gson gson;
    private PersonInfoBean infoBean = null;
    public InfoModelImpl(){
        gson = new Gson();
    }
    @Override
    public void setInfo(PersonInfoBean info) {
        infoBean = info;
        String infoStr = gson.toJson(info);
        SharedPreferencesManager.getInstance().saveString(KEY.INFO_MODEL, infoStr);
    }

    @Override
    public PersonInfoBean getInfo() {
        if(infoBean == null){
            String infoStr = SharedPreferencesManager.getInstance().getString(KEY.INFO_MODEL, "");
            if(!CommonUtil.isEmpty(infoStr)){
                infoBean = gson.fromJson(infoStr,PersonInfoBean.class);
            }
        }
        return infoBean;
    }
}
