package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyUser;
import com.zhiliao.pojo.WlyyUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * 用户mapper
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public interface WlyyUserMapper {
    int countByExample(WlyyUserExample example);

    int deleteByExample(WlyyUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WlyyUser record);

    int insertSelective(WlyyUser record);

    List<WlyyUser> selectByExample(WlyyUserExample example);

    WlyyUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WlyyUser record, @Param("example") WlyyUserExample example);

    int updateByExample(@Param("record") WlyyUser record, @Param("example") WlyyUserExample example);

    int updateByPrimaryKeySelective(WlyyUser record);

    int updateByPrimaryKey(WlyyUser record);

    WlyyUser login(WlyyUser record);
}