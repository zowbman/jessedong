package com.goldray.backend.model.po;

/**
 * Created by zwb on 2017/4/19.
 */
public class ProductListPo {
    private String code;
    private int categoriesId;
    private String title;
    private String path;
    private String coverImgName;
    private int addTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
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

    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
    }
}
