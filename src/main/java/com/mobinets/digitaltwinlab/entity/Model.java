package com.mobinets.digitaltwinlab.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Model {
    private  int id; //模型id
    private  String fileName; //模型文件名
    //上传时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date uploadDate; //上传日期
    //上传者id
    private  int uploaderId; //上传者id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(int uploaderId) {
        this.uploaderId = uploaderId;
    }
}
