package com.anjian.enterprise.model.request;

/**
 * Created by LiMing on 2018/7/1.
 */

public class AddListRequest {

    /**
     * current : 1
     * size : 10
     * condition : {"id":"1012329476849090561"}
     */

    private int current;
    private int size;
    private ConditionBean condition=new ConditionBean();

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ConditionBean getCondition() {
        return condition;
    }

    public void setCondition(ConditionBean condition) {
        this.condition = condition;
    }

    public static class ConditionBean {
        /**
         * id : 1012329476849090561
         */

        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
