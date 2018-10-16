package com.anjian.enterprise.model.home;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */

public class HomeNewsModel {

    /**
     * code : 200
     * count : 1
     * data : [{"areaIds":null,"content":null,"createBy":null,"createTime":"2018-10-16 09:58:25","hotSpot":0,"id":"1052015873964331009","imageUrl":"/cms/2018/10/16/d2cde92819f848bb8ec0e8c08d6aa97e.png","summary":"这是摘要!!","title":"这是标题!!","updateBy":null,"updateTime":null}]
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

    public static class DataBean {
        /**
         * areaIds : null
         * content : null
         * createBy : null
         * createTime : 2018-10-16 09:58:25
         * hotSpot : 0
         * id : 1052015873964331009
         * imageUrl : /cms/2018/10/16/d2cde92819f848bb8ec0e8c08d6aa97e.png
         * summary : 这是摘要!!
         * title : 这是标题!!
         * updateBy : null
         * updateTime : null
         */

        private Object areaIds;
        private Object content;
        private Object createBy;
        private String createTime;
        private int hotSpot;
        private String id;
        private String imageUrl;
        private String summary;
        private String title;
        private Object updateBy;
        private Object updateTime;

        public Object getAreaIds() {
            return areaIds;
        }

        public void setAreaIds(Object areaIds) {
            this.areaIds = areaIds;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getHotSpot() {
            return hotSpot;
        }

        public void setHotSpot(int hotSpot) {
            this.hotSpot = hotSpot;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }
    }
}
