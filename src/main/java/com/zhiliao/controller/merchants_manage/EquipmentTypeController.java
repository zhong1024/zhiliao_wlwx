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
 *
 * @author Mr.Zhong
 * @create2019-07-30 8:53
 */
@Controller
public class EquipmentTypeController {


    @Autowired
    EquipmentTypeService equipmentTypeService;


    /**
     * @return
     */
    @RequestMapping("ToEquipmentTypeList")
    public String ToEquipmentTypeList() {
        return "merchants_manage/EquipmentTypeList";
    }


    /**
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("ToEquipmentTypeUpdate")
    public String ToEquipmentTypeUpdate(Integer id, Model model) {
        model.addAttribute("id", id);
        return "/merchants_manage/EquipmentTypeUpdate";
    }

    /**
     * 商家添加跳转
     *
     * @return
     */
    @RequestMapping("ToEquipmentTypeAdd")
    public String EquipmentTypeAdd(){
        return "/merchants_manage/EquipmentTypeAdd";
    }


    /**
     * 查询所有记录数
     *
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("EquipmentTypeList")
    @ResponseBody
    public Map<String, Object> EquipmentTypeList(String searContent, Integer page, Integer limit) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        PageHelper.startPage(page, limit);
        List<WlyyBusiness> EquipmentTypeList ;
        if("".equals(searContent) || searContent == null){
            EquipmentTypeList = equipmentTypeService.selectByExample();
        }else{
            EquipmentTypeList = equipmentTypeService.selectAllListKey(searContent);
        }
        PageInfo<WlyyBusiness> pageInfo = new PageInfo<>(EquipmentTypeList);

        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());  //总记录数
        map.put("data", pageInfo.getList());    //结果集
        return map;

    }


    /**
     * 根据ID查询对应的记录数
     *
     * @param id
     * @return
     */
    @RequestMapping("grtEquipmentTypeId")
    @ResponseBody
    public Map<String, Object> grtEquipmentTypeId(Integer id) throws Exception {
        WlyyBusiness wlyyBusiness = equipmentTypeService.selectByPrimaryKey(id);
        Map<String, Object> map = new HashMap<>();
        map.put("datas", wlyyBusiness);
        return map;
    }

    /**
     * 修改数据
     *
     * @param id    键值
     * @param field 得到字段
     * @param value 修改后的值
     * @return
     */
    @RequestMapping("updateEquipmentTypeId")
    @ResponseBody
    public Msg updateEquipmentTypeId(Integer id, String field, String value) {

        WlyyBusiness wlyyBusiness = new WlyyBusiness();
        wlyyBusiness.setId(id);
        wlyyBusiness.setBusinessName(value);
        equipmentTypeService.updateByPrimaryKeySelective(wlyyBusiness);

        return Msg.success();
    }


    /**
     * 根据ID删除某条数据
     *
     * @param
     * @return
     */
    @RequestMapping("deleteEquipmentTypeId")
    @ResponseBody
    public Msg deleteEquipmentTypeId(Integer Id) {
        equipmentTypeService.deleteByPrimaryKey(Id);
        return Msg.success();
    }

    /**
     * 添加一条记录
     *
     * @param business_name
     * @return
     */
    @RequestMapping("EquipmentTypeAdd")
    @ResponseBody
    public Msg EquipmentTypeAdd(String business_name) throws Exception{
        equipmentTypeService.insert(business_name);
        return Msg.success();
    }


}
