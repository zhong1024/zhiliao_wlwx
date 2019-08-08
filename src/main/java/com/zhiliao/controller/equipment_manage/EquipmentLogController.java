package com.zhiliao.controller.equipment_manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiliao.pojo.WlyyDeviceLog;
import com.zhiliao.service.equipment_type.EquipmentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志信息Controller
 *
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */
@Controller
public class EquipmentLogController {


    @Autowired
    EquipmentLogService equipmentLogService;


    @RequestMapping("ToEquipmentLogList")
    public String ToEquipmentLogList() {
        return "/equipment_manage/EquipmentLogList";
    }


    /**
     * 多表关联查询出所有结果集
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("EquipmentLogList")
    @ResponseBody
    public Map<String, Object> EquipmentLogList(String searContent, Integer page, Integer limit) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        PageHelper.startPage(page, limit);
        List<WlyyDeviceLog> EquipmentLogList;
        if ("".equals(searContent) || searContent == null) {
            EquipmentLogList = equipmentLogService.selectAllList();
        } else {
            EquipmentLogList = equipmentLogService.selectAllListKey(searContent);
        }
        PageInfo<WlyyDeviceLog> pageInfo = new PageInfo<>(EquipmentLogList);

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());  //总记录数
        map.put("data", pageInfo.getList());    //结果集
        return map;
    }


}
