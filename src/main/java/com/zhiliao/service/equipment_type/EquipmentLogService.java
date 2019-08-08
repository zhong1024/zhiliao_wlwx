package com.zhiliao.service.equipment_type;

import com.zhiliao.dao.WlyyDeviceLogMapper;
import com.zhiliao.pojo.WlyyDeviceLog;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 日志信息管理Service实现类
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:12
 */
@Service
public class EquipmentLogService {


    @Resource
    WlyyDeviceLogMapper wlyyDeviceLogMapper;


    /**
     * 查询所有数据信息
     *
     * @return
     * @throws Exception
     */
    public List<WlyyDeviceLog> selectByExample() throws Exception {
        return wlyyDeviceLogMapper.selectByExample(null);
    }

    /**
     * 根据ID修改在线状态
     *
     * @param wlyyDeviceLog
     * @return
     * @throws Exception
     */
    public int updateTypeKey(WlyyDeviceLog wlyyDeviceLog) throws Exception {
        return wlyyDeviceLogMapper.updateTypeKey(wlyyDeviceLog);
    }

    /**
     * 多表关联查询出结果集
     *
     * @return
     * @throws Exception
     */
    public List<WlyyDeviceLog> selectAllList() throws Exception {
        return wlyyDeviceLogMapper.selectAllList();
    }


    /**
     * 条件多表关联查询出结果集
     *
     * @param searContent
     * @return
     * @throws Exception
     */
    public List<WlyyDeviceLog> selectAllListKey(String searContent) throws Exception {
        return wlyyDeviceLogMapper.selectAllListKey(searContent);
    }

}
