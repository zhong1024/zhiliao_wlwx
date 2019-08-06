package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyDeviceType;
import com.zhiliao.pojo.WlyyDeviceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public interface WlyyDeviceTypeMapper {
    int countByExample(WlyyDeviceTypeExample example);

    int deleteByExample(WlyyDeviceTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WlyyDeviceType record);

    int insertSelective(WlyyDeviceType record);

    List<WlyyDeviceType> selectByExample(WlyyDeviceTypeExample example);

    WlyyDeviceType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WlyyDeviceType record, @Param("example") WlyyDeviceTypeExample example);

    int updateByExample(@Param("record") WlyyDeviceType record, @Param("example") WlyyDeviceTypeExample example);

    int updateByPrimaryKeySelective(WlyyDeviceType record);

    int updateByPrimaryKey(WlyyDeviceType record);
}