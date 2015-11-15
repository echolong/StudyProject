package com.example.study.studyproject.model;

import com.example.study.studyproject.bean.PersonInfoBean;

/**
 * Created by liuyulong on 15/11/14.
 */
public interface InfoModel {
    /**
     * 设置数据并保存
     * @param info
     */
    void setInfo(PersonInfoBean info);

    /**
     * 获取数据
     * @return
     */
    PersonInfoBean getInfo();
}
