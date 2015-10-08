package com.example.study.studyproject.obj;

/**
 * @autho：liuyulong on 2015/9/24 15:44
 */
public class ImageInfoObject {
    private int infoSource;
    private String infoText;

    public ImageInfoObject(int res, String info) {
        this.infoSource = res;
        this.infoText = info;
    }

    public int getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(int infoSource) {
        this.infoSource = infoSource;
    }

    public String getInfoText() {
        return infoText;
    }

    public void setInfoText(String infoText) {
        this.infoText = infoText;
    }
}
