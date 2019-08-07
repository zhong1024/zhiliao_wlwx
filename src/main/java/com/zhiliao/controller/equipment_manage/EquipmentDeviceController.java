package com.zhiliao.controller.equipment_manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiliao.pojo.WlyyDevice;
import com.zhiliao.service.equipment_type.EquipmentDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备信息Controller
 * @author Mr.Zhong
 * @create2019-08-01 15:24
 */
@Controller
public class EquipmentDeviceController {


    @Autowired
    EquipmentDeviceService equipmentDeviceService;

    @RequestMapping("ToEquipmentDeviceList")
    public String ToEquipmentDeviceList(){
        return "/equipment_manage/EquipmentDeviceList";
    }


    @RequestMapping("EquipmentDeviceList")
    @ResponseBody
    public Map<String, Object> EquipmentDeviceList(HttpServletRequest request) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();

        PageHelper.startPage(Integer.valueOf(request.getParameter("page")), Integer.valueOf(request.getParameter("limit")));
        List<WlyyDevice> EquipmentDeviceList = equipmentDeviceService.selectAllList();
        PageInfo<WlyyDevice> pageInfo = new PageInfo<>(EquipmentDeviceList);

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());  //总记录数
        map.put("data", pageInfo.getList());    //结果集
        return map;

    }


}
