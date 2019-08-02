package com.zhiliao.controller.equipment_manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiliao.pojo.WlyyBusiness;
import com.zhiliao.pojo.WlyyDeviceLog;
import com.zhiliao.pojo.WlyyDeviceType;
import com.zhiliao.service.equipment_manage.EquipmentTypeService;
import com.zhiliao.service.equipment_type.EquipmentLogService;
import com.zhiliao.service.merchants_manage.MerchantsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-08-01 14:13
 */
@Controller
public class EquipmentLogController {


    @Autowired
    EquipmentLogService equipmentLogService;

    @Autowired
    MerchantsManageService merchantsManageService;

    @Autowired
    EquipmentTypeService equipmentTypeService;


    @RequestMapping("ToEquipmentLogList")
    public String ToEquipmentLogList(){
        return "/equipment_manage/EquipmentLogList";
    }


    @RequestMapping("EquipmentLogList")
    @ResponseBody
    public Map<String, Object> EquipmentLogList(HttpServletRequest request) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();

        PageHelper.startPage(Integer.valueOf(request.getParameter("page")), Integer.valueOf(request.getParameter("limit")));
        List<WlyyDeviceLog> EquipmentLogList = equipmentLogService.selectByExample();
        
//        List<WlyyDeviceType> wlyyDeviceTypeList = merchantsManageService.selectByExample(); //物联网类型
//        String[] wlyyDeviceTypeListARR = new String[wlyyDeviceTypeList.size()];
//        for(int i = 0;i<wlyyDeviceTypeList.size();i++){
//            wlyyDeviceTypeListARR[wlyyDeviceTypeList.get(i).getId()] = wlyyDeviceTypeList.get(i).getName();
//        }
//        List<WlyyBusiness> wlyyBusinessList = equipmentTypeService.selectByExample();   //商家
//        String[] wlyyBusinessListARR = new String[wlyyBusinessList.size()];
//        for(int i = 0;i<wlyyBusinessList.size();i++){
//            wlyyBusinessListARR[wlyyBusinessList.get(i).getId()] = wlyyBusinessList.get(i).getBusinessName();
//        }
//        for(int i = 0;i<EquipmentLogList.size();i++){
//            EquipmentLogList.get(i).setTypeName(wlyyDeviceTypeListARR[EquipmentLogList.get(i).getTypeId()]);
//            EquipmentLogList.get(i).setBusinessName(wlyyBusinessListARR[EquipmentLogList.get(i).getBusinessId()]);
//        }
//        System.out.println(EquipmentLogList.get(0).getBusinessName());
        PageInfo<WlyyDeviceLog> pageInfo = new PageInfo<>(EquipmentLogList);

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());  //总记录数
        map.put("data", pageInfo.getList());    //结果集
        return map;

    }


}
