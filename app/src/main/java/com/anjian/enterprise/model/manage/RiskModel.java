package com.anjian.enterprise.model.manage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/9/3.
 */

public class RiskModel {

    /**
     * code : 200
     * count : 0
     * data : {"moreHight":[],"normal":[],"low":[{"caseSerious":"2","caseSeriousText":"严重,重伤/职业病(多人)","createBy":"988422934076903425","createName":null,"createTime":"2018-09-03 15:54:35","dangerLevel":null,"dangerName":"测试","dangerRate":"2","dangerRateText":"每月一次暴露","detailPosition":null,"enterpriseId":"1020316826354462722","enterpriseName":null,"happenCasePossible":"4","happenCasePossibleText":"可能,但不经常","happenCaseType":"3","happenCaseTypeText":"机械伤害","id":"1036522828217090050","isDel":0,"levelText":"低风险","localeImg":"/dangerIdentification/2018/9/3/235da349c86349528531339f89774c8e.png","lossPrediction":null,"modifyStep":null,"score":42,"unitType":"1","unitTypeText":"管理单元","updateBy":"988422934076903425","updateTime":"2018-09-03 15:54:35"}],"hight":[{"caseSerious":"4","caseSeriousText":"灾难,数人死亡","createBy":"988422934076903425","createName":null,"createTime":"2018-09-03 15:55:32","dangerLevel":null,"dangerName":"高风险测试","dangerRate":"5","dangerRateText":"连续暴露","detailPosition":null,"enterpriseId":"1020316826354462722","enterpriseName":null,"happenCasePossible":"6","happenCasePossibleText":"完全可能预料","happenCaseType":"5","happenCaseTypeText":"触电","id":"1036523067082702849","isDel":0,"levelText":"高风险","localeImg":"/dangerIdentification/2018/9/3/e15d2dfd357b4130bc90d3c433a9af80.png","lossPrediction":null,"modifyStep":null,"score":4000,"unitType":"2","unitTypeText":"动力单元","updateBy":"988422934076903425","updateTime":"2018-09-03 15:55:32"}]}
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
        private List<LowBean> moreHight;
        private List<LowBean> normal;
        private List<LowBean> low;
        private List<LowBean> hight;

        public List<LowBean> getMoreHight() {
            return moreHight;
        }

        public void setMoreHight(List<LowBean> moreHight) {
            this.moreHight = moreHight;
        }

        public List<LowBean> getNormal() {
            return normal;
        }

        public void setNormal(List<LowBean> normal) {
            this.normal = normal;
        }

        public List<LowBean> getLow() {
            return low;
        }

        public void setLow(List<LowBean> low) {
            this.low = low;
        }

        public List<LowBean> getHight() {
            return hight;
        }

        public void setHight(List<LowBean> hight) {
            this.hight = hight;
        }

        public static class LowBean implements Serializable{
            /**
             * caseSerious : 2
             * caseSeriousText : 严重,重伤/职业病(多人)
             * createBy : 988422934076903425
             * createName : null
             * createTime : 2018-09-03 15:54:35
             * dangerLevel : null
             * dangerName : 测试
             * dangerRate : 2
             * dangerRateText : 每月一次暴露
             * detailPosition : null
             * enterpriseId : 1020316826354462722
             * enterpriseName : null
             * happenCasePossible : 4
             * happenCasePossibleText : 可能,但不经常
             * happenCaseType : 3
             * happenCaseTypeText : 机械伤害
             * id : 1036522828217090050
             * isDel : 0
             * levelText : 低风险
             * localeImg : /dangerIdentification/2018/9/3/235da349c86349528531339f89774c8e.png
             * lossPrediction : null
             * modifyStep : null
             * score : 42.0
             * unitType : 1
             * unitTypeText : 管理单元
             * updateBy : 988422934076903425
             * updateTime : 2018-09-03 15:54:35
             */

            private String caseSerious;
            private String caseSeriousText;
            private String createBy;
            private Object createName;
            private String createTime;
            private Object dangerLevel;
            private String dangerName;
            private String dangerRate;
            private String dangerRateText;
            private Object detailPosition;
            private String enterpriseId;
            private Object enterpriseName;
            private String happenCasePossible;
            private String happenCasePossibleText;
            private String happenCaseType;
            private String happenCaseTypeText;
            private String id;
            private int isDel;
            private String levelText;
            private String localeImg;
            private Object lossPrediction;
            private Object modifyStep;
            private double score;
            private String unitType;
            private String unitTypeText;
            private String updateBy;
            private String updateTime;

            public String getCaseSerious() {
                return caseSerious;
            }

            public void setCaseSerious(String caseSerious) {
                this.caseSerious = caseSerious;
            }

            public String getCaseSeriousText() {
                return caseSeriousText;
            }

            public void setCaseSeriousText(String caseSeriousText) {
                this.caseSeriousText = caseSeriousText;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public Object getCreateName() {
                return createName;
            }

            public void setCreateName(Object createName) {
                this.createName = createName;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getDangerLevel() {
                return dangerLevel;
            }

            public void setDangerLevel(Object dangerLevel) {
                this.dangerLevel = dangerLevel;
            }

            public String getDangerName() {
                return dangerName;
            }

            public void setDangerName(String dangerName) {
                this.dangerName = dangerName;
            }

            public String getDangerRate() {
                return dangerRate;
            }

            public void setDangerRate(String dangerRate) {
                this.dangerRate = dangerRate;
            }

            public String getDangerRateText() {
                return dangerRateText;
            }

            public void setDangerRateText(String dangerRateText) {
                this.dangerRateText = dangerRateText;
            }

            public Object getDetailPosition() {
                return detailPosition;
            }

            public void setDetailPosition(Object detailPosition) {
                this.detailPosition = detailPosition;
            }

            public String getEnterpriseId() {
                return enterpriseId;
            }

            public void setEnterpriseId(String enterpriseId) {
                this.enterpriseId = enterpriseId;
            }

            public Object getEnterpriseName() {
                return enterpriseName;
            }

            public void setEnterpriseName(Object enterpriseName) {
                this.enterpriseName = enterpriseName;
            }

            public String getHappenCasePossible() {
                return happenCasePossible;
            }

            public void setHappenCasePossible(String happenCasePossible) {
                this.happenCasePossible = happenCasePossible;
            }

            public String getHappenCasePossibleText() {
                return happenCasePossibleText;
            }

            public void setHappenCasePossibleText(String happenCasePossibleText) {
                this.happenCasePossibleText = happenCasePossibleText;
            }

            public String getHappenCaseType() {
                return happenCaseType;
            }

            public void setHappenCaseType(String happenCaseType) {
                this.happenCaseType = happenCaseType;
            }

            public String getHappenCaseTypeText() {
                return happenCaseTypeText;
            }

            public void setHappenCaseTypeText(String happenCaseTypeText) {
                this.happenCaseTypeText = happenCaseTypeText;
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

            public String getLevelText() {
                return levelText;
            }

            public void setLevelText(String levelText) {
                this.levelText = levelText;
            }

            public String getLocaleImg() {
                return localeImg;
            }

            public void setLocaleImg(String localeImg) {
                this.localeImg = localeImg;
            }

            public Object getLossPrediction() {
                return lossPrediction;
            }

            public void setLossPrediction(Object lossPrediction) {
                this.lossPrediction = lossPrediction;
            }

            public Object getModifyStep() {
                return modifyStep;
            }

            public void setModifyStep(Object modifyStep) {
                this.modifyStep = modifyStep;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public String getUnitType() {
                return unitType;
            }

            public void setUnitType(String unitType) {
                this.unitType = unitType;
            }

            public String getUnitTypeText() {
                return unitTypeText;
            }

            public void setUnitTypeText(String unitTypeText) {
                this.unitTypeText = unitTypeText;
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
}
