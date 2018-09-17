package com.anjian.enterprise.model.main;

/**
 * Created by Administrator on 2018/6/28.
 */

public class LoginModel {


    /**
     * code : 200
     * count : 0
     * data : {"placeType":0,"areaId":"1041576354735632386","userTypeDesc":"企场用户","areaName":"金井社区","placeId":"1041577991650848769","userType":"2","token":"53bf9cd51077b2498010fc3177509816"}
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
         * placeType : 0
         * areaId : 1041576354735632386
         * userTypeDesc : 企场用户
         * areaName : 金井社区
         * placeId : 1041577991650848769
         * userType : 2
         * token : 53bf9cd51077b2498010fc3177509816
         */

        private int placeType;
        private String areaId;
        private String userTypeDesc;
        private String areaName;
        private String placeId;
        private String userType;
        private String token;

        public int getPlaceType() {
            return placeType;
        }

        public void setPlaceType(int placeType) {
            this.placeType = placeType;
        }

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getUserTypeDesc() {
            return userTypeDesc;
        }

        public void setUserTypeDesc(String userTypeDesc) {
            this.userTypeDesc = userTypeDesc;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getPlaceId() {
            return placeId;
        }

        public void setPlaceId(String placeId) {
            this.placeId = placeId;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
