package com.mobinets.digitaltwinlab.entity;


import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
public class AccessLog {
    private int id;

    private int memberId;

    private int direction;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int member_id) {
        this.memberId = member_id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


    @Override
    public String toString() {
        return "AccessLog{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", direction=" + direction +
                ", time=" + time +
                '}';
    }
}
