package com.anjian.enterprise.model.request;

/**
 * Created by Administrator on 2018/7/3.
 */

public class AddQiYeCheckRequest {
    private String enterpriseId;
    private String pdpId;
    private String dangerDesc;
    private String localeImg;
    private String modifyStep;
    private int modifyExpire;
    private String lawReason;
    private String saferSign;
    private String businesserSign;
    private String witherSign;
    private String modifyImg;

    public String getPdpId() {
        return pdpId;
    }

    public void setPdpId(String pdpId) {
        this.pdpId = pdpId;
    }

    public int getModifyExpire() {
        return modifyExpire;
    }

    public void setModifyExpire(int modifyExpire) {
        this.modifyExpire = modifyExpire;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getDangerDesc() {
        return dangerDesc;
    }

    public void setDangerDesc(String dangerDesc) {
        this.dangerDesc = dangerDesc;
    }

    public String getLocaleImg() {
        return localeImg;
    }

    public void setLocaleImg(String localeImg) {
        this.localeImg = localeImg;
    }

    public String getModifyStep() {
        return modifyStep;
    }

    public void setModifyStep(String modifyStep) {
        this.modifyStep = modifyStep;
    }

    public String getLawReason() {
        return lawReason;
    }

    public void setLawReason(String lawReason) {
        this.lawReason = lawReason;
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
