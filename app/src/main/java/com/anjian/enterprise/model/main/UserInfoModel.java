package com.anjian.enterprise.model.main;

import java.util.List;

/**
 * Created by Administrator on 2018/7/18.
 */

public class UserInfoModel {

    /**
     * code : 200
     * count : 0
     * data : {"account":"abcabc","address":null,"areaIdList":["1","988374382449651713","988374448447025153","988438702663471106"],"avatar":null,"birthDay":null,"createBy":"1","createTime":"2018-04-23 22:22:46","deptId":"0","deptName":null,"email":null,"enable":1,"id":"988422934076903425","idCard":null,"isDel":0,"namePinyin":null,"oldPassword":null,"password":"ZWZjZDVkZDQ1YWIxNjYwMDhiNDFkN2RmOTUyODE3NjA=","phone":null,"position":null,"qq":null,"remark":null,"role":null,"sex":0,"staffNo":null,"updateBy":null,"updateTime":"2018-04-24 18:42:21","userName":"abc","userType":"1","weiBo":null,"weiXin":null}
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
         * account : abcabc
         * address : null
         * areaIdList : ["1","988374382449651713","988374448447025153","988438702663471106"]
         * avatar : null
         * birthDay : null
         * createBy : 1
         * createTime : 2018-04-23 22:22:46
         * deptId : 0
         * deptName : null
         * email : null
         * enable : 1
         * id : 988422934076903425
         * idCard : null
         * isDel : 0
         * namePinyin : null
         * oldPassword : null
         * password : ZWZjZDVkZDQ1YWIxNjYwMDhiNDFkN2RmOTUyODE3NjA=
         * phone : null
         * position : null
         * qq : null
         * remark : null
         * role : null
         * sex : 0
         * staffNo : null
         * updateBy : null
         * updateTime : 2018-04-24 18:42:21
         * userName : abc
         * userType : 1
         * weiBo : null
         * weiXin : null
         */

        private String account;
        private String address;
        private String avatar;
        private String birthDay;
        private String createBy;
        private String createTime;
        private String deptId;
        private String deptName;
        private String email;
        private int enable;
        private String id;
        private String idCard;
        private int isDel;
        private String namePinyin;
        private String oldPassword;
        private String password;
        private String phone;
        private String position;
        private String qq;
        private String remark;
        private String role;
        private int sex;
        private String staffNo;
        private String updateBy;
        private String updateTime;
        private String userName;
        private String userType;
        private String weiBo;
        private String weiXin;
        private List<String> areaIdList;

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getBirthDay() {
            return birthDay;
        }

        public void setBirthDay(String birthDay) {
            this.birthDay = birthDay;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public int getIsDel() {
            return isDel;
        }

        public void setIsDel(int isDel) {
            this.isDel = isDel;
        }

        public String getNamePinyin() {
            return namePinyin;
        }

        public void setNamePinyin(String namePinyin) {
            this.namePinyin = namePinyin;
        }

        public String getOldPassword() {
            return oldPassword;
        }

        public void setOldPassword(String oldPassword) {
            this.oldPassword = oldPassword;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getStaffNo() {
            return staffNo;
        }

        public void setStaffNo(String staffNo) {
            this.staffNo = staffNo;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getWeiBo() {
            return weiBo;
        }

        public void setWeiBo(String weiBo) {
            this.weiBo = weiBo;
        }

        public String getWeiXin() {
            return weiXin;
        }

        public void setWeiXin(String weiXin) {
            this.weiXin = weiXin;
        }

        public List<String> getAreaIdList() {
            return areaIdList;
        }

        public void setAreaIdList(List<String> areaIdList) {
            this.areaIdList = areaIdList;
        }
    }
}
