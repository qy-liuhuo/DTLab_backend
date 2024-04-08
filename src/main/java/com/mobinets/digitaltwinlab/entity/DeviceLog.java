package com.mobinets.digitaltwinlab.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class DeviceLog {
    private int id; //注意与设备ID区分，此ID为日志编号
    private int deviceId; //设备ID
    private String oldValue; //旧值
    private String newValue; //新值
    private String operation; //操作对象（修改的属性）
    private int cleared; //是否被删除
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date changeDate; //修改日期

    private int operatorId; //操作者ID
    private String deviceName; //设备名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String old_value) {
        this.oldValue = old_value;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String new_value) {
        this.newValue = new_value;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getCleared() {
        return cleared;
    }

    public void setCleared(int cleared) {
        this.cleared = cleared;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
