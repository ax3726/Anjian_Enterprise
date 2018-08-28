package com.anjian.enterprise.model.main;

/**
 * Created by Administrator on 2018/6/28.
 */

public class LoginModel {

    /**
     * code : 200
     * count : 0
     * data : 7187581dd1f73b7fb5a2ae931615c13a
     * message : 成功
     */

    private int code;
    private int count;
    private String data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
