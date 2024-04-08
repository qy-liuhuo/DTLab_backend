package com.mobinets.digitaltwinlab.service;

import com.alibaba.fastjson.JSONObject;
import com.mobinets.digitaltwinlab.dao.AccessLogMapper;
import com.mobinets.digitaltwinlab.dao.StaffMapper;
import com.mobinets.digitaltwinlab.entity.AccessLog;
import com.mobinets.digitaltwinlab.entity.Staff;
import com.mobinets.digitaltwinlab.websocket.impl.WebSocketScheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    WebSocketScheduled webSocketScheduled;
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private AccessLogMapper accessLogMapper;

    public void saveToLog(int memberId,int action,long time){
        AccessLog accessLog = new AccessLog();

        accessLog.setMemberId(memberId);
        accessLog.setDirection(action);
        accessLog.setTime(new Date(Long.parseLong(String.valueOf(time))));
        System.out.println(accessLog);
        accessLogMapper.insertLog(accessLog);
    }

    /**
     * 更新数据库状态
     * @param memberId
     * @param action
     */
    public void updatePersonState(int memberId ,int action){
        if (action == 0) {
            staffMapper.updatePersonState(memberId,"In_Lab");
        }
        else if (action == 1) {
            staffMapper.updatePersonState(memberId,"Out_Lab");
        }
        else if (action == 2){
            staffMapper.updatePersonState(memberId,"In_Meeting_Room");
        }
        else if (action == 3) {
            staffMapper.updatePersonState(memberId,"In_Lab");
        }
    }

    public void sendUpdateInfo(int memberId){
        JSONObject result=new JSONObject();
        result.put("type","peopleInout");
        Staff persionInfo= staffMapper.selectByMemberId(memberId);
        result.put("info",persionInfo);
        webSocketScheduled.sendInfoAll(JSONObject.toJSONString(result));
    }

    public List<AccessLog> selectAccessLogs(){
        return accessLogMapper.selectAll();
    }

    public List<Staff> selectStaffs(){
        return staffMapper.selectAllStaff();
    }
}
