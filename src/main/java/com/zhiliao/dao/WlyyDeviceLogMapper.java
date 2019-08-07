package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyDeviceLog;
import com.zhiliao.pojo.WlyyDeviceLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

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

    //  根据ID修改在线状态
    int updateTypeKey(WlyyDeviceLog record);
    //  多表关联查询出结果集
    List<WlyyDeviceLog> selectAllList();
}