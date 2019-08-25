package com.dcits.testspringbootdemo.bean;

/**
 * @author Malthael
 * @date 2019/8/22
 */
public class User {
    private Integer account;
    private String password;
    private String name;
    private String signature;
    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
