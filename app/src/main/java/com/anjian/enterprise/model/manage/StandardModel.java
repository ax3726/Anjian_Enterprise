package com.anjian.enterprise.model.manage;

import java.util.List;

/**
 * Created by Administrator on 2018/8/28.
 */

public class StandardModel {

    /**
     * code : 200
     * count : 0
     * data : [{"bucketName":"security-files","eTag":"DE7F697B1C20EDB5F5B64806DC780171","fileName":"标杆企业双机制建设汇报材料","key":"https://security-files.oss-cn-shenzhen.aliyuncs.com/1019771090000818177/2018/8/27/1019771090000818177-标杆企业双机制建设汇报材料.doc","lastModified":"2018-08-27 16:39:19","owner":null,"size":"9550848","storageClass":null}]
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
         * bucketName : security-files
         * eTag : DE7F697B1C20EDB5F5B64806DC780171
         * fileName : 标杆企业双机制建设汇报材料
         * key : https://security-files.oss-cn-shenzhen.aliyuncs.com/1019771090000818177/2018/8/27/1019771090000818177-标杆企业双机制建设汇报材料.doc
         * lastModified : 2018-08-27 16:39:19
         * owner : null
         * size : 9550848
         * storageClass : null
         */

        private String bucketName;
        private String eTag;
        private String fileName;
        private String key;
        private String lastModified;
        private Object owner;
        private String size;
        private Object storageClass;

        public String getBucketName() {
            return bucketName;
        }

        public void setBucketName(String bucketName) {
            this.bucketName = bucketName;
        }

        public String getETag() {
            return eTag;
        }

        public void setETag(String eTag) {
            this.eTag = eTag;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getLastModified() {
            return lastModified;
        }

        public void setLastModified(String lastModified) {
            this.lastModified = lastModified;
        }

        public Object getOwner() {
            return owner;
        }

        public void setOwner(Object owner) {
            this.owner = owner;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public Object getStorageClass() {
            return storageClass;
        }

        public void setStorageClass(Object storageClass) {
            this.storageClass = storageClass;
        }
    }
}
