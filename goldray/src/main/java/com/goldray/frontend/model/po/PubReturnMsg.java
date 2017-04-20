package com.goldray.frontend.model.po;

import com.goldray.config.CustomPropertyPlaceholderConfigurer;
import com.goldray.util.BaseUtil;

/**
 * Created by zwb on 2017/2/27.公共返回协议
 */
public class PubReturnMsg {
    private int code;//返回码
    private String msg;//信息
    private int time;//服务器时间
    private Object data;//数据

    public PubReturnMsg() {
        super();
    }

    public PubReturnMsg(int code) {
        this.code = code;
        this.msg = CustomPropertyPlaceholderConfigurer.getStringValue(String.valueOf(code));
        this.time = BaseUtil.currentTimeMillis();
    }

    public PubReturnMsg(int code, String appendMsg) {
        this.code = code;
        this.msg = CustomPropertyPlaceholderConfigurer.getStringValue(String.valueOf(code));
        this.msg += "," + appendMsg;
        this.time = BaseUtil.currentTimeMillis();
    }

    public PubReturnMsg(int code, Object data) {
        this.code = code;
        this.msg = CustomPropertyPlaceholderConfigurer.getStringValue(String.valueOf(code));
        this.time = BaseUtil.currentTimeMillis();
        this.data = data;
    }

    public PubReturnMsg(int code, String appendMsg, Object data) {
        this.code = code;
        this.msg = CustomPropertyPlaceholderConfigurer.getStringValue(String.valueOf(code));
        this.msg += "," + appendMsg;
        this.time = BaseUtil.currentTimeMillis();
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
