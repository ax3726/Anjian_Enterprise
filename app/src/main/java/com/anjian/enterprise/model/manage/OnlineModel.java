package com.anjian.enterprise.model.manage;

/**
 * Created by Administrator on 2018/9/17.
 */

public class OnlineModel {

    /**
     * code : 200
     * count : 0
     * data : {"areaCode":"362251","contactName":"王先生","contactPhone":"13000000000","createBy":"1","createTime":"2018-09-17 14:35:29","id":"1041576354735632386","isDel":0,"isParent":null,"layer":3,"name":"金井社区","orderNum":0,"parentCode":"350582106000","parentId":"1041575915914964993","parentName":null,"remark":null,"size":null,"status":0,"updateBy":"1","updateTime":"2018-09-17 14:35:29"}
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
         * areaCode : 362251
         * contactName : 王先生
         * contactPhone : 13000000000
         * createBy : 1
         * createTime : 2018-09-17 14:35:29
         * id : 1041576354735632386
         * isDel : 0
         * isParent : null
         * layer : 3
         * name : 金井社区
         * orderNum : 0
         * parentCode : 350582106000
         * parentId : 1041575915914964993
         * parentName : null
         * remark : null
         * size : null
         * status : 0
         * updateBy : 1
         * updateTime : 2018-09-17 14:35:29
         */

        private String areaCode;
        private String contactName;
        private String contactPhone;
        private String createBy;
        private String createTime;
        private String id;
        private int isDel;
        private Object isParent;
        private int layer;
        private String name;
        private int orderNum;
        private String parentCode;
        private String parentId;
        private Object parentName;
        private Object remark;
        private Object size;
        private int status;
        private String updateBy;
        private String updateTime;

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getContactName() {
            return contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactPhone() {
            return contactPhone;
        }

        public void setContactPhone(String contactPhone) {
            this.contactPhone = contactPhone;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getIsDel() {
            return isDel;
        }

        public void setIsDel(int isDel) {
            this.isDel = isDel;
        }

        public Object getIsParent() {
            return isParent;
        }

        public void setIsParent(Object isParent) {
            this.isParent = isParent;
        }

        public int getLayer() {
            return layer;
        }

        public void setLayer(int layer) {
            this.layer = layer;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(int orderNum) {
            this.orderNum = orderNum;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        public String getParentId() {
            return parentId;
        }

        public void setParentId(String parentId) {
            this.parentId = parentId;
        }

        public Object getParentName() {
            return parentName;
        }

        public void setParentName(Object parentName) {
            this.parentName = parentName;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Object getSize() {
            return size;
        }

        public void setSize(Object size) {
            this.size = size;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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
    }
}
