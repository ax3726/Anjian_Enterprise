package com.anjian.enterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/8/28.
 */

public class DocPathModel implements Serializable {
    private String local_path;
    private String url;

    public String getLocal_path() {
        return local_path;
    }

    public void setLocal_path(String local_path) {
        this.local_path = local_path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
