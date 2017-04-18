package com.goldray.backend.model.po;

/**
 * Created by zwb on 2017/4/18. fileupload result
 */
public class FUResult {
    private String state;
    private String url;

    public FUResult(String state){
        this.state = state;
    }

    public FUResult(String state, String url) {
        this.state = state;
        this.url = url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
