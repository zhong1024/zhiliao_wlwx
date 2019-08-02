package com.zhiliao.service.merchants_manage;

import com.zhiliao.dao.WlyyDeviceTypeMapper;
import com.zhiliao.pojo.WlyyDeviceType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**物联网类型信息Service实现类
 * @author Mr.Zhong
 * @create2019-07-30 9:38
 */
@Service
public class MerchantsManageService {


    @Resource
    WlyyDeviceTypeMapper wlyyDeviceTypeMapper;


    /**
     * 查询所有数据信息
     * @return
     * @throws Exception
     */
    public List<WlyyDeviceType> selectByExample() throws Exception{
        return wlyyDeviceTypeMapper.selectByExample(null);
    }

    /**
     * 根据ID查询某条数据信息
     * @param id
     * @return
     * @throws Exception
     */
    public WlyyDeviceType selectByPrimaryKey(Integer id) throws Exception{
        return wlyyDeviceTypeMapper.selectByPrimaryKey(id);
    }


}
