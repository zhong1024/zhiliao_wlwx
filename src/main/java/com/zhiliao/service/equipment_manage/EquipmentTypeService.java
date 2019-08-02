package com.zhiliao.service.equipment_manage;

import com.zhiliao.dao.WlyyBusinessMapper;
import com.zhiliao.pojo.WlyyBusiness;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**商家信息管理Service实现类
 * @author Mr.Zhong
 * @create2019-07-30 8:54
 */
@Service
public class EquipmentTypeService {


    @Resource
    WlyyBusinessMapper wlyyBusinessMapper;


    /**
     * 查询使用数据信息
     * @return
     * @throws Exception
     */
    public List<WlyyBusiness> selectByExample() throws Exception{
        return wlyyBusinessMapper.selectByExample(null);
    }

    /**
     * 根据id查询某条数据信息
     * @param id
     * @return
     * @throws Exception
     */
    public WlyyBusiness getStaffById(Integer id) throws Exception{
        return wlyyBusinessMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改某条信息
     * @param wlyyBusiness
     */
    public void updateEquipmentTypeId(WlyyBusiness wlyyBusiness){
        wlyyBusinessMapper.updateByPrimaryKey(wlyyBusiness);
    }

}
