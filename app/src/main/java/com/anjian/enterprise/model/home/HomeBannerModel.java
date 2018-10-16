package com.anjian.enterprise.model.home;

import java.util.List;

/**
 * Created by Administrator on 2018/10/16.
 */

public class HomeBannerModel {

    /**
     * code : 200
     * count : 2
     * data : [{"areaIds":null,"content":null,"createBy":null,"createTime":"2018-10-16 09:59:22","hotSpot":1,"id":"1052016115396857857","imageUrl":"/cms/2018/10/16/adcde10420754b309753616ba475694d.png","summary":"水淀粉苏打粉卡上交罚款是对放假啦使肌肤大量水分即可啦上 ","title":"哈哈测试","updateBy":null,"updateTime":null},{"areaIds":null,"content":null,"createBy":null,"createTime":"2018-10-11 21:37:47","hotSpot":1,"id":"1050379939674017794","imageUrl":null,"summary":"少年班的成立是一场教学改革的实验。它的出现无疑对正规高等教育的恢复与发展产生很强的推动力。如今，少年班的培养宗旨也悄然发生变化，由最初培养顶尖科学家，转为培养各个领域的领军人物。","title":"少年班40年的教育理念之变：由培养顶尖科学家到培养领军人物","updateBy":null,"updateTime":null}]
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
         * createTime : 2018-10-16 09:59:22
         * hotSpot : 1
         * id : 1052016115396857857
         * imageUrl : /cms/2018/10/16/adcde10420754b309753616ba475694d.png
         * summary : 水淀粉苏打粉卡上交罚款是对放假啦使肌肤大量水分即可啦上
         * title : 哈哈测试
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
