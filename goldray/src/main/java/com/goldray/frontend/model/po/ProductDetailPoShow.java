package com.goldray.frontend.model.po;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
public class ProductDetailPoShow {
    private String code;
    private String title;
    private String introduction;
    private List<String> pdImg;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getPdImg() {
        return pdImg;
    }

    public void setPdImg(List<String> pdImg) {
        this.pdImg = pdImg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
