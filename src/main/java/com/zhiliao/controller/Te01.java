package com.zhiliao.controller;

import com.zhiliao.netty.GetServer;
import com.zhiliao.pojo.WlyyDeviceLog;
import com.zhiliao.service.TeService;
import com.zhiliao.service.equipment_type.EquipmentLogService;
import com.zhiliao.service.merchants_manage.MerchantsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.channels.Channel;
import java.util.List;

/**
 * 测试类
 *
 * @author Mr.Zhong
 * @create2019-07-29 12:19
 */
@Controller
public class Te01 {

    @Autowired
    TeService teService;

    @Autowired
    MerchantsManageService merchantsManageService;

    @Autowired
    EquipmentLogService equipmentLogService;


    /**
     * 根据ID修改在线状态
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("updateTypeKeyss")
    public String updateTypeKey() throws Exception {

        WlyyDeviceLog wlyyDeviceLog = new WlyyDeviceLog();
        wlyyDeviceLog.setId(1);
        wlyyDeviceLog.setTypeId(1);
        equipmentLogService.updateTypeKey(wlyyDeviceLog);
        return "/ok";

    }

}
