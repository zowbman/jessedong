package com.goldray.backend.model.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zwb on 2017/4/11.
 */
public class BannerVo {
    private int id;
    private String title;
    private MultipartFile bannerImg;
    private int isShow;

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

    public MultipartFile getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(MultipartFile bannerImg) {
        this.bannerImg = bannerImg;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return "id:" + this.id + ",title:" + this.title + ",bannerImg:" + bannerImg + ",isShow" + this.isShow;
    }
}
