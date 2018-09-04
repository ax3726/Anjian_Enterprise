package com.anjian.enterprise.model.main;

/**
 * Created by Administrator on 2018/6/28.
 */

public class LoginModel {

    /**
     * code : 200
     * count : 0
     * data : {"placeId":"1024913629628477441","placeType":0,"token":"2157ab46947d2837627c9a6cf38fe72b"}
     * message : 成功
     */

    private int code;
    private int count;
    private DataBean data;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * placeId : 1024913629628477441
         * placeType : 0
         * token : 2157ab46947d2837627c9a6cf38fe72b
         */

        private String placeId;
        private int placeType;
        private String token;

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public int getPlaceType() {
            return placeType;
        }

        public void setPlaceType(int placeType) {
            this.placeType = placeType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
