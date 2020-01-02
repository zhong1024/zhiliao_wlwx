package com.zhiliao.controller.equipment_type;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhiliao.pojo.WlyyDeviceType;
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
 * 物联网类型信息表
 *
 * @author Mr.Zhong
 * @create2019-07-30 9:37
 */
@Controller
public class MerchantsManageController {


    @Autowired
    MerchantsManageService merchantsManageService;

    /**
     * @return
     */
    @RequestMapping("ToMerchantsManageList")
    public String ToMerchantsManageList() {
        return "/equipment_type/MerchantsManageList";
    }

    /**
     * 查询所有记录数
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("MerchantsManageList")
    @ResponseBody
    public Map<String, Object> MerchantsManageList(HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        PageHelper.startPage(Integer.valueOf(request.getParameter("page")), Integer.valueOf(request.getParameter("limit")));
        List<WlyyDeviceType> MerchantsManageList = merchantsManageService.selectByExample();
        PageInfo<WlyyDeviceType> pageInfo = new PageInfo<>(MerchantsManageList);


        map.put("code", 0);
        map.put("msg", "");
        map.put("count", pageInfo.getTotal());  //总记录数
        map.put("data", pageInfo.getList());    //结果集
        return map;

    }

}
