package com.goldray.backend.model.po;

/**
 * Created by zwb on 2017/4/11.
 */
public class BannerPo {
    private int id;
    private String title;
    private String path;
    private String imgName;
    private String url;
    private int isShow;
    private int isBlank;
    private int addTime;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getIsBlank() {
        return isBlank;
    }

    public void setIsBlank(int isBlank) {
        this.isBlank = isBlank;
    }

    public int getAddTime() {
        return addTime;
    }


    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }
}
