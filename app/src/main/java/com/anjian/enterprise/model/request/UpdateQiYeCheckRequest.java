package com.anjian.enterprise.model.request;

/**
 * Created by Administrator on 2018/7/3.
 */

public class UpdateQiYeCheckRequest {
    private String id;
    private String saferSign;
    private String businesserSign;
    private String witherSign;
    private String modifyImg;
    private String enterpriseId;
    private String pdpId;

    public String getPdpId() {
        return pdpId;
    }

    public void setPdpId(String pdpId) {
        this.pdpId = pdpId;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSaferSign() {
        return saferSign;
    }

    public void setSaferSign(String saferSign) {
        this.saferSign = saferSign;
    }

    public String getBusinesserSign() {
        return businesserSign;
    }

    public void setBusinesserSign(String businesserSign) {
        this.businesserSign = businesserSign;
    }

    public String getWitherSign() {
        return witherSign;
    }

    public void setWitherSign(String witherSign) {
        this.witherSign = witherSign;
    }

    public String getModifyImg() {
        return modifyImg;
    }

    public void setModifyImg(String modifyImg) {
        this.modifyImg = modifyImg;
    }
}
