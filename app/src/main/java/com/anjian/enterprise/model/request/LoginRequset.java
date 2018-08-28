package com.anjian.enterprise.model.request;

/**
 * Created by Administrator on 2018/6/28.
 */

public class LoginRequset {
    private String account;
    private String password;

    public LoginRequset(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
