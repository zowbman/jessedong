package com.goldray.backend.model.po;

/**
 * Created by zwb on 2017/4/19.
 */
public class ProductPo {
    private int id;
    private String code;
    private String title;
    private int categoriesId;
    private String introduction;
    private int addTime;
    private String path;
    private String coverImgName;
    private String firstImgName;
    private String secondImgName;
    private String thirdImgName;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getAddTime() {
        return addTime;
    }

    public void setAddTime(int addTime) {
        this.addTime = addTime;
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

    public String getFirstImgName() {
        return firstImgName;
    }

    public void setFirstImgName(String firstImgName) {
        this.firstImgName = firstImgName;
    }

    public String getSecondImgName() {
        return secondImgName;
    }

    public void setSecondImgName(String secondImgName) {
        this.secondImgName = secondImgName;
    }

    public String getThirdImgName() {
        return thirdImgName;
    }

    public void setThirdImgName(String thirdImgName) {
        this.thirdImgName = thirdImgName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "code:" + this.code + ",title:" + this.title + ",categoriesId:" + categoriesId + ",introduction:" + introduction + ",addTime:" + addTime + ",path:" + path + ",coverImgName:" + coverImgName + ",firstImgName:" + firstImgName + ",secondImgName:" + secondImgName + ",thirdImgName:" + thirdImgName;
    }
}
