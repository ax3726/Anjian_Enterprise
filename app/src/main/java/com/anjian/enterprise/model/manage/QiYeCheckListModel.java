package com.anjian.enterprise.model.manage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */

public class QiYeCheckListModel {

    /**
     * code : 200
     * count : 1
     * data : [{"businesserSign":"/localeExamine/2018/7/3/1e55a02ec7564616913ff82a571aaa6a.png","createBy":"988422934076903425","createName":null,"createTime":"2018-07-03 16:37:52","dangerDesc":"啦啦啦啦啦啦啦","enterpriseId":"1013739992192516097","enterpriseName":null,"id":"1014065673329950721","isDel":0,"lawReason":"开玩笑","localeImg":"/localeExamine/2018/7/3/3672c4469ad14ffc82118c10fc584956.png","modifyImg":null,"modifyStatus":0,"modifyStep":"啊咯","modifyTime":null,"saferSign":"/localeExamine/2018/7/3/ab992715ce444cb2a38d121f6fe394f1.png","updateBy":"988422934076903425","updateTime":"2018-07-04 14:52:29","witherSign":"/localeExamine/2018/7/3/e976639e49e74f8c85d0f6ced92655c6.png"}]
     * message : 成功
     */

    private int code;
    private int count;
    private String message;
    private List<DataBean> data;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * businesserSign : /localeExamine/2018/7/3/1e55a02ec7564616913ff82a571aaa6a.png
         * createBy : 988422934076903425
         * createName : null
         * createTime : 2018-07-03 16:37:52
         * dangerDesc : 啦啦啦啦啦啦啦
         * enterpriseId : 1013739992192516097
         * enterpriseName : null
         * id : 1014065673329950721
         * isDel : 0
         * lawReason : 开玩笑
         * localeImg : /localeExamine/2018/7/3/3672c4469ad14ffc82118c10fc584956.png
         * modifyImg : null
         * modifyStatus : 0
         * modifyStep : 啊咯
         * modifyTime : null
         * saferSign : /localeExamine/2018/7/3/ab992715ce444cb2a38d121f6fe394f1.png
         * updateBy : 988422934076903425
         * updateTime : 2018-07-04 14:52:29
         * witherSign : /localeExamine/2018/7/3/e976639e49e74f8c85d0f6ced92655c6.png
         */

        private String businesserSign;
        private String createBy;
        private String createName;
        private String createTime;
        private String dangerDesc;
        private String enterpriseId;
        private String enterpriseName;
        private String pdpId;
        private String pdpName;
        private String id;
        private int isDel;
        private String lawReason;
        private String localeImg;
        private String modifyImg;
        private int modifyStatus;
        private String modifyStep;
        private int modifyExpire;
        private String modifyTime;
        private String saferSign;
        private String updateBy;
        private String updateTime;
        private String witherSign;

        public String getPdpId() {
            return pdpId;
        }

        public void setPdpId(String pdpId) {
            this.pdpId = pdpId;
        }

        public String getPdpName() {
            return pdpName;
        }

        public void setPdpName(String pdpName) {
            this.pdpName = pdpName;
        }

        public int getModifyExpire() {
            return modifyExpire;
        }

        public void setModifyExpire(int modifyExpire) {
            this.modifyExpire = modifyExpire;
        }

        public String getBusinesserSign() {
            return businesserSign;
        }

        public void setBusinesserSign(String businesserSign) {
            this.businesserSign = businesserSign;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateName() {
            return createName;
        }

        public void setCreateName(String createName) {
            this.createName = createName;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDangerDesc() {
            return dangerDesc;
        }

        public void setDangerDesc(String dangerDesc) {
            this.dangerDesc = dangerDesc;
        }

        public String getEnterpriseId() {
            return enterpriseId;
        }

        public void setEnterpriseId(String enterpriseId) {
            this.enterpriseId = enterpriseId;
        }

        public String getEnterpriseName() {
            return enterpriseName;
        }

        public void setEnterpriseName(String enterpriseName) {
            this.enterpriseName = enterpriseName;
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

        public String getLawReason() {
            return lawReason;
        }

        public void setLawReason(String lawReason) {
            this.lawReason = lawReason;
        }

        public String getLocaleImg() {
            return localeImg;
        }

        public void setLocaleImg(String localeImg) {
            this.localeImg = localeImg;
        }

        public String getModifyImg() {
            return modifyImg;
        }

        public void setModifyImg(String modifyImg) {
            this.modifyImg = modifyImg;
        }

        public int getModifyStatus() {
            return modifyStatus;
        }

        public void setModifyStatus(int modifyStatus) {
            this.modifyStatus = modifyStatus;
        }

        public String getModifyStep() {
            return modifyStep;
        }

        public void setModifyStep(String modifyStep) {
            this.modifyStep = modifyStep;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getSaferSign() {
            return saferSign;
        }

        public void setSaferSign(String saferSign) {
            this.saferSign = saferSign;
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

        public String getWitherSign() {
            return witherSign;
        }

        public void setWitherSign(String witherSign) {
            this.witherSign = witherSign;
        }
    }
}
