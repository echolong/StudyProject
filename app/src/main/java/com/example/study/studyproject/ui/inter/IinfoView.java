package com.example.study.studyproject.ui.inter;

import com.example.study.studyproject.bean.PersonInfoBean;

/**
 * Created by liuyulong on 15/11/14.
 */
public interface IinfoView {
    /**
     * 网view设置内容
     * @param info
     */
    void setInfo(PersonInfoBean info);

    /**
     * 从view中读取数据
     * @return
     */
    PersonInfoBean getInfo();
}
