package com.anjian.enterprise.model.request;

/**
 * Created by Administrator on 2018/9/4.
 */

public class AddDangerRecordRequest {
    private String dangerIdentificationId;
    private String signImg;
    private int isDanger;//0有隐患 1无隐患

    public String getDangerIdentificationId() {
        return dangerIdentificationId;
    }

    public void setDangerIdentificationId(String dangerIdentificationId) {
        this.dangerIdentificationId = dangerIdentificationId;
    }

    public String getSignImg() {
        return signImg;
    }

    public void setSignImg(String signImg) {
        this.signImg = signImg;
    }

    public int getIsDanger() {
        return isDanger;
    }

    public void setIsDanger(int isDanger) {
        this.isDanger = isDanger;
    }
}
