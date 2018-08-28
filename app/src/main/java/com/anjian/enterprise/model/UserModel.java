package com.anjian.enterprise.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/6/28.
 */

public class UserModel implements Serializable{
    private String user;
    private String password;

    public UserModel(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
