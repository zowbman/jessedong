package com.goldray.frontend.model.po;

/**
 * Created by zwb on 2017/4/20.
 */
public class BannerPo {
    private String title;
    private String path;
    private String imgName;
    private String url;
    private int isBlank;

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

    public int getIsBlank() {
        return isBlank;
    }

    public void setIsBlank(int isBlank) {
        this.isBlank = isBlank;
    }
}
