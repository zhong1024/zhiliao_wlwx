package com.zhiliao.controller.merchants_manage;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiliao.pojo.WlyyBusiness;
import com.zhiliao.service.equipment_manage.EquipmentTypeService;
import com.zhiliao.util.Msg;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家信息管理Controller
 * @author Mr.Zhong
 * @create2019-07-30 8:53
 */
@Controller
public class EquipmentTypeController {


    @Autowired
    EquipmentTypeService equipmentTypeService;

    /**
     *
     * @return
     */
    @RequestMapping("ToEquipmentTypeList")
    public String ToEquipmentTypeList(){
        return "merchants_manage/EquipmentTypeList";
    }


    @RequestMapping("ToEquipmentTypeUpdate")
    public String ToEquipmentTypeUpdate(Integer id , Model model){
        model.addAttribute("id",id);
        return "/merchants_manage/EquipmentTypeUpdate";
    }




    /**
     *  查询所有记录数
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("EquipmentTypeList")
    @ResponseBody
    public Map<String, Object> EquipmentTypeList(HttpServletRequest request) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();

        PageHelper.startPage(Integer.valueOf(request.getParameter("page")), Integer.valueOf(request.getParameter("limit")));
        List<WlyyBusiness> EquipmentTypeList = equipmentTypeService.selectByExample();
        PageInfo<WlyyBusiness> pageInfo = new PageInfo<>(EquipmentTypeList);

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());  //总记录数
        map.put("data", pageInfo.getList());    //结果集
        return map;

    }


    /**
     *  根据ID查询对应的记录数
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("grtEquipmentTypeId")
    public Map<String,Object> grtEquipmentTypeId(Integer id ) throws Exception{
        WlyyBusiness wlyyBusiness = equipmentTypeService.getStaffById(id);
        Map<String,Object> map = new HashMap<>();
        map.put("datas",wlyyBusiness);
        return map;
    }

    /**
     *
     * @param wlyyBusiness
     * @return
     */
    @ResponseBody
    @RequestMapping("updateEquipmentTypeId")
    public Msg updateEquipmentTypeId(WlyyBusiness wlyyBusiness){
        equipmentTypeService.updateEquipmentTypeId(wlyyBusiness);
        return Msg.success();
    }



}
