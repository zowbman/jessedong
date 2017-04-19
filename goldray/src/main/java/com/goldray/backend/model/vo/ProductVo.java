package com.goldray.backend.model.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zwb on 2017/4/19.
 */
public class ProductVo {
    private String code;
    private String title;
    private int categoriesId;
    private String introduction;
    private MultipartFile coverImg;
    private MultipartFile firstImg;
    private MultipartFile secondImg;
    private MultipartFile thirdImg;
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

    public MultipartFile getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(MultipartFile coverImg) {
        this.coverImg = coverImg;
    }

    public MultipartFile getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(MultipartFile firstImg) {
        this.firstImg = firstImg;
    }

    public MultipartFile getSecondImg() {
        return secondImg;
    }

    public void setSecondImg(MultipartFile secondImg) {
        this.secondImg = secondImg;
    }

    public MultipartFile getThirdImg() {
        return thirdImg;
    }

    public void setThirdImg(MultipartFile thirdImg) {
        this.thirdImg = thirdImg;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "code:" + this.code + ",title:" + this.title + ",categoriesId:" + this.categoriesId + ",introduction:" + this.introduction
                + ",coverImg is null:" + (this.coverImg == null ? "true" : this.coverImg.isEmpty())
                + ",firstImg is null:" + (this.firstImg == null ? "true" : this.firstImg.isEmpty())
                + ",secondImg is null:" + (this.secondImg == null ? "true" : this.secondImg.isEmpty())
                + ",thirdImg is null:" + (this.thirdImg == null ? "true" : this.thirdImg.isEmpty());
    }
}
