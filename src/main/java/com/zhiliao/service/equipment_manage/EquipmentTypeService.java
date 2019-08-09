package com.zhiliao.service.equipment_manage;

import com.zhiliao.dao.WlyyBusinessMapper;
import com.zhiliao.pojo.WlyyBusiness;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商家信息管理Service实现类
 *
 * @author Mr.Zhong
 * @create2019-07-30 8:54
 */
@Service
public class EquipmentTypeService {


    @Resource
    WlyyBusinessMapper wlyyBusinessMapper;


    /**
     * 查询所有数据信息
     *
     * @return
     * @throws Exception
     */
    public List<WlyyBusiness> selectByExample() throws Exception {
        return wlyyBusinessMapper.selectByExample(null);
    }

    /**
     * 根据id查询某条数据信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    public WlyyBusiness selectByPrimaryKey(Integer id) throws Exception {
        return wlyyBusinessMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改某条信息
     *
     * @param wlyyBusiness
     */
    public int updateByPrimaryKeySelective(WlyyBusiness wlyyBusiness) {
        return wlyyBusinessMapper.updateByPrimaryKeySelective(wlyyBusiness);
    }


    /**
     * 根据ID删除某条数据
     *
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(Integer id) {
        return wlyyBusinessMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据条件搜索信息
     *
     * @param searContent
     * @return
     * @throws Exception
     */
    public List<WlyyBusiness> selectAllListKey(String searContent) throws Exception {
        return wlyyBusinessMapper.selectAllListKey(searContent);
    }

    /**
     * 添加一条记录
     *
     * @param business_name
     * @return
     * @throws Exception
     */
    public int insert(String business_name) throws Exception {
        WlyyBusiness wlyyBusiness = new WlyyBusiness();
        wlyyBusiness.setBusinessName(business_name);
        return wlyyBusinessMapper.insert(wlyyBusiness);
    }

}
