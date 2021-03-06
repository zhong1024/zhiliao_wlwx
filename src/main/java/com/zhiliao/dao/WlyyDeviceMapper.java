package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyDevice;
import com.zhiliao.pojo.WlyyDeviceExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 设备类型dao接口
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public interface WlyyDeviceMapper {

    int countByExample(WlyyDeviceExample example);

    int deleteByExample(WlyyDeviceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WlyyDevice record);

    int insertSelective(WlyyDevice record);

    List<WlyyDevice> selectByExample(WlyyDeviceExample example);

    WlyyDevice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WlyyDevice record, @Param("example") WlyyDeviceExample example);

    int updateByExample(@Param("record") WlyyDevice record, @Param("example") WlyyDeviceExample example);

    int updateByPrimaryKeySelective(WlyyDevice record);

    int updateByPrimaryKey(WlyyDevice record);

    //  多表关联查询出结果集
    List<WlyyDevice> selectAllList();

    //  条件多表关联查询出结果集
    List<WlyyDevice> selectAllListKey(String searContent);

}