package com.mobinets.digitaltwinlab.dao;


import com.mobinets.digitaltwinlab.entity.AccessLog;
import com.mobinets.digitaltwinlab.entity.DeviceLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccessLogMapper {

    List<AccessLog> selectAll();

    List<DeviceLog> selectByMemberId(int memberId);

    int insertLog(AccessLog accessLog);

}
