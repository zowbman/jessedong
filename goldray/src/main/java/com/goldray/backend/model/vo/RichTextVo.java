package com.goldray.backend.model.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by zwb on 2017/4/18.
 */
public class RichTextVo {
    private int id;
    private int richType;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRichType() {
        return richType;
    }

    public void setRichType(int richType) {
        this.richType = richType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ",richType:" + this.richType + ",addTime:" + addTime;
    }
}
