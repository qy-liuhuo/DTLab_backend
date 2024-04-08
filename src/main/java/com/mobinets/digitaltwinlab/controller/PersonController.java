package com.mobinets.digitaltwinlab.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mobinets.digitaltwinlab.dao.StaffMapper;
import com.mobinets.digitaltwinlab.entity.AccessLog;
import com.mobinets.digitaltwinlab.entity.Staff;
import com.mobinets.digitaltwinlab.service.PersonService;
import com.mobinets.digitaltwinlab.util.response.Response;
import com.mobinets.digitaltwinlab.websocket.impl.WebSocketScheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private PersonService personService;

    /**
     * 获得所有人员
     * @return
     */
    @GetMapping("/getAllStaff")
    @ResponseBody
    public Response getAllStaff(){

        Map<String,List<Staff>> data=new HashMap<>();
        data.put("staffs",personService.selectStaffs());
        return  Response.success(JSON.parseObject(JSON.toJSONString(data),Map.class));
    }

    @GetMapping("/getAccessLogs")
    @ResponseBody
    public Response getAccessLogs(){
        Map<String,List<AccessLog>> data=new HashMap<>();
        data.put("logs",personService.selectAccessLogs());
        return  Response.success(JSON.parseObject(JSON.toJSONString(data),Map.class));
    }

    /**
     * 更改人员状态（测试使用）
     * @return
     */
    @RequestMapping(path="/inout",method = RequestMethod.POST)
    @ResponseBody
    public Response inout(@RequestParam("time") long time,@RequestParam("direction") int direction ,@RequestParam("memberId") int memberId) {
        personService.saveToLog(memberId,direction,time);
        personService.updatePersonState(memberId,direction);
        personService.sendUpdateInfo(memberId);
        return Response.success();
    }



}
