package com.anjian.enterprise.model.request;

/**
 * Created by Administrator on 2018/9/3.
 */

public class AddRiskRequest {
    private String dangerName;
    private String enterpriseId;
    private String localeImg;
    private String happenCaseType;
    private String happenCasePossible;
    private String dangerRate;
    private String caseSerious;
    private String unitType;

    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getLocaleImg() {
        return localeImg;
    }

    public void setLocaleImg(String localeImg) {
        this.localeImg = localeImg;
    }

    public String getHappenCaseType() {
        return happenCaseType;
    }

    public void setHappenCaseType(String happenCaseType) {
        this.happenCaseType = happenCaseType;
    }

    public String getHappenCasePossible() {
        return happenCasePossible;
    }

    public void setHappenCasePossible(String happenCasePossible) {
        this.happenCasePossible = happenCasePossible;
    }

    public String getDangerRate() {
        return dangerRate;
    }

    public void setDangerRate(String dangerRate) {
        this.dangerRate = dangerRate;
    }

    public String getCaseSerious() {
        return caseSerious;
    }

    public void setCaseSerious(String caseSerious) {
        this.caseSerious = caseSerious;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }
}
