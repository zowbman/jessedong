package com.goldray.backend.model.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zwb on 2017/4/19.
 */
public class NewsVo {
    private int id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    private int isTop;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ",title:" + this.title + ",isTop:" + this.isTop + ",addTime" + this.addTime;
    }
}
