package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyBusiness;
import com.zhiliao.pojo.WlyyBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WlyyBusinessMapper {
    int countByExample(WlyyBusinessExample example);

    int deleteByExample(WlyyBusinessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WlyyBusiness record);

    int insertSelective(WlyyBusiness record);

    List<WlyyBusiness> selectByExample(WlyyBusinessExample example);

    WlyyBusiness selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WlyyBusiness record, @Param("example") WlyyBusinessExample example);

    int updateByExample(@Param("record") WlyyBusiness record, @Param("example") WlyyBusinessExample example);

    int updateByPrimaryKeySelective(WlyyBusiness record);

    int updateByPrimaryKey(WlyyBusiness record);
}