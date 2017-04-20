package com.goldray.frontend.model.po;

/**
 * Created by zwb on 2017/4/20.
 */
public class ProductPo {
    private String code;
    private String title;
    private String path;
    private String coverImgName;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCoverImgName() {
        return coverImgName;
    }

    public void setCoverImgName(String coverImgName) {
        this.coverImgName = coverImgName;
    }
}
