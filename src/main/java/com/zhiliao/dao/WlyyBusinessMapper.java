package com.zhiliao.dao;

import com.zhiliao.pojo.WlyyBusiness;
import com.zhiliao.pojo.WlyyBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */

public interface WlyyBusinessMapper {
    //  按条件计数
    int countByExample(WlyyBusinessExample example);
    //  按条件删除
    int deleteByExample(WlyyBusinessExample example);
    //  按主键删除
    int deleteByPrimaryKey(Integer id);
    //  插入数据（返回值为ID）
    int insert(WlyyBusiness record);

    int insertSelective(WlyyBusiness record);
    //  按条件查询
    List<WlyyBusiness> selectByExample(WlyyBusinessExample example);
    //  按主键查询
    WlyyBusiness selectByPrimaryKey(Integer id);
    //  按条件更新值不为null的字段
    int updateByExampleSelective(@Param("record") WlyyBusiness record, @Param("example") WlyyBusinessExample example);
    //  按条件更新
    int updateByExample(@Param("record") WlyyBusiness record, @Param("example") WlyyBusinessExample example);
    //  按主键更新值不为null的字段
    int updateByPrimaryKeySelective(WlyyBusiness record);

    int updateByPrimaryKey(WlyyBusiness record);
}