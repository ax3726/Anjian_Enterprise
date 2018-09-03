package com.anjian.enterprise.model.manage;

import java.util.List;

/**
 * Created by Administrator on 2018/9/3.
 */

public class RiskListModel {
    private int type;// 1  2  3  4
    private List<RiskModel.DataBean.LowBean> data;

    public RiskListModel(int type, List<RiskModel.DataBean.LowBean> data) {
        this.type = type;
        this.data = data;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<RiskModel.DataBean.LowBean> getData() {
        return data;
    }

    public void setData(List<RiskModel.DataBean.LowBean> data) {
        this.data = data;
    }
}
