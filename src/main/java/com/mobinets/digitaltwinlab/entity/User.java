package com.mobinets.digitaltwinlab.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Map;

public class User {
    private int id;
    private String campusNum; //学号
    private String username; //用户名
    private String password; //密码
    private String salt; //密码加密随机噪声
    private String email; //邮箱
    private int type; //类别
    private int status; //状态
    private String activationCode; //激活码
    private String headerUrl; //用户头像地址
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime; //创建时间
    //是否删除
    private int ifDeleted; //是否已注销
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCampusNum() {
        return campusNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCampusNum(String campusNum) {
        this.campusNum = campusNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getHeaderUrl() {
        return headerUrl;
    }

    public void setHeaderUrl(String headerUrl) {
        this.headerUrl = headerUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getIfDeleted() {
        return ifDeleted;
    }

    public void setIfDeleted(int ifDeleted) {
        this.ifDeleted = ifDeleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", campusNum=" + campusNum +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", activationCode='" + activationCode + '\'' +
                ", headerUrl='" + headerUrl + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
