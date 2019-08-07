package com.zhiliao.service.equipment_type;

import com.zhiliao.dao.WlyyDeviceMapper;
import com.zhiliao.pojo.WlyyDevice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 设备信息管理Service实现类
 *
 * @author Mr.Zhong
 * @create2019-08-01 15:19
 */
@Service
public class EquipmentDeviceService {


    @Resource
    WlyyDeviceMapper wlyyDeviceMapper;

    /**
     * 查询所有数据信息
     *
     * @return
     * @throws Exception
     */
    public List<WlyyDevice> selectByExample() throws Exception {
        return wlyyDeviceMapper.selectByExample(null);
    }

    /**
     * 多表关联查询出结果集
     *
     * @return
     * @throws Exception
     */
    public List<WlyyDevice> selectAllList() throws Exception {
        return wlyyDeviceMapper.selectAllList();
    }


}
