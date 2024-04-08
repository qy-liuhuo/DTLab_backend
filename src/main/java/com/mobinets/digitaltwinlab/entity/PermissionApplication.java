package com.mobinets.digitaltwinlab.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class PermissionApplication {
    private int id; //申请编号
    private int applicantId; //申请者ID
    private int permissionApplyFor; //申请的权限
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date date; //申请日期

    private int ifProcessed; //处理标志字段
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date processedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(int applicantId) {
        this.applicantId = applicantId;
    }

    public int getPermissionApplyFor() {
        return permissionApplyFor;
    }

    public void setPermissionApplyFor(int permissionApplyFor) {
        this.permissionApplyFor = permissionApplyFor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIfProcessed() {
        return ifProcessed;
    }

    public void setIfProcessed(int ifProcessed) {
        this.ifProcessed = ifProcessed;
    }

    public Date getProcessedDate() {
        return processedDate;
    }

    public void setProcessedDate(Date processedDate) {
        this.processedDate = processedDate;
    }

    @Override
    public String toString() {
        return "permissionApplication{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", permissionApplyFor=" + permissionApplyFor +
                ", date=" + date +
                ", ifProcessed=" + ifProcessed +
                ", processedDate=" + processedDate +
                '}';
    }
}
