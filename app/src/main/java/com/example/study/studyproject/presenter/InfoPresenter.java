package com.example.study.studyproject.presenter;

import com.example.study.studyproject.bean.PersonInfoBean;
import com.example.study.studyproject.model.InfoModelImpl;
import com.example.study.studyproject.ui.inter.IinfoView;

/**
 * Created by liuyulong on 15/11/14.
 */
public class InfoPresenter {
    private IinfoView iView;
    private InfoModelImpl infoModel;
    public InfoPresenter(IinfoView view) {
        iView = view;
        infoModel = new InfoModelImpl();
    }

    public void setInfo(){
        PersonInfoBean info = iView.getInfo();
        infoModel.setInfo(info);
    }

    public void getInfo(){
        PersonInfoBean infoBean = infoModel.getInfo();
        iView.setInfo(infoBean);
    }
}
