package com.mobinets.digitaltwinlab.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mobinets.digitaltwinlab.service.DeviceTypeService;
import com.mobinets.digitaltwinlab.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
@RestController
@RequestMapping("/deviceTypeManager")
public class DeviceTypeController {

    @Autowired
    private DeviceTypeService deviceTypeService;
    /**
     * 获得所有设备类别
     */
    @RequestMapping(path = "/getAllType", method = RequestMethod.GET)
    public Response getAllClass(HttpServletRequest request, HttpServletResponse httpResponse){
        return deviceTypeService.selectAllDeviceType();
    }

    @RequestMapping(path="addNewDeviceType",method = RequestMethod.POST)
    public Response addNewDeviceType(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse httpResponse){
        JSONObject deviceTypeInfo= JSON.parseObject((String) params.get("data"));
        String typeName=deviceTypeInfo.getString("name");
        String description=deviceTypeInfo.getString("description");
        if(deviceTypeService.addDeviceTypeToDb(typeName,description)){
            if(deviceTypeService.addDeviceTypeInfoToRedis(deviceTypeInfo)){
                return Response.success();
            }
        }
        return Response.failure("设备名重复或其他未知错误");
    }

    /**
     * 获得指定设备类型的信息
     * @param typeName
     * @param request
     * @param httpResponse
     * @return
     */
    @RequestMapping(path="deviceTypeInfo",method = RequestMethod.POST)
    public Response deviceTypeInfo(@RequestParam("typeName") String typeName, HttpServletRequest request, HttpServletResponse httpResponse){
        System.out.println(typeName);
        return deviceTypeService.selectDeviceTypeInfo(typeName);
    }
}