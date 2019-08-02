package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyDeviceLog;
import com.zhiliao.pojo.WlyyDeviceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WlyyDeviceLogMapper {
    int countByExample(WlyyDeviceLogExample example);

    int deleteByExample(WlyyDeviceLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WlyyDeviceLog record);

    int insertSelective(WlyyDeviceLog record);

    List<WlyyDeviceLog> selectByExample(WlyyDeviceLogExample example);

    WlyyDeviceLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WlyyDeviceLog record, @Param("example") WlyyDeviceLogExample example);

    int updateByExample(@Param("record") WlyyDeviceLog record, @Param("example") WlyyDeviceLogExample example);

    int updateByPrimaryKeySelective(WlyyDeviceLog record);

    int updateByPrimaryKey(WlyyDeviceLog record);
}