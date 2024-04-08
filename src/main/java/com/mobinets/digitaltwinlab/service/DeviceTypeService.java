package com.mobinets.digitaltwinlab.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mobinets.digitaltwinlab.dao.DeviceTypeMapper;
import com.mobinets.digitaltwinlab.entity.DeviceType;
import com.mobinets.digitaltwinlab.entity.Model;
import com.mobinets.digitaltwinlab.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeviceTypeService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private DeviceTypeMapper deviceTypeMapper;

    public Response selectAllDeviceType(){
        List<DeviceType> deviceTypeList=deviceTypeMapper.selectAll();
        Map<String,List<DeviceType>> deviceTypeMapItem = new HashMap<String,List<DeviceType>>();
        deviceTypeMapItem.put("deviceTypes",deviceTypeList);
        return Response.success(JSON.parseObject(JSON.toJSONString(deviceTypeMapItem),Map.class));
    }

    /**
     * 将新类型写入数据库
     * @param type_name
     * @param description
     * @return
     */
    public Boolean addDeviceTypeToDb(String type_name,String description){
//        DeviceType temp= deviceTypeMapper.selectDeviceTypeByName(type_name);
//        if (temp!=null){
//            return false;
//        }
//        DeviceType newType=new DeviceType();
//        newType.setTypeName(type_name);
//        newType.setDescription(description);
//        deviceTypeMapper.insertDeviceType(newType);
        return true;
    }

    /**
     * 将新信息写入redis
     * @param json
     * @return
     */
    public Boolean addDeviceTypeInfoToRedis(JSONObject json){
        System.out.println(json);
//        //redis中已经存在同名信息
//        if(redisTemplate.opsForValue().get(json.getString("name"))!=null){
//            return false;
//        }
//        else{
//            redisTemplate.opsForValue().set(json.getString("name"),json);
//        }
        return true;
    }

    public Response selectDeviceTypeInfo(String key){
        Object result=redisTemplate.opsForValue().get(key);
        if(result==null){
            return Response.failure("设备名不存在");
        }
        else {
            Map<String,Object> data=new HashMap<>();
            data.put("info",result);
            return Response.success(data);
        }
    }
}
