package com.zhiliao.controller;
import com.zhiliao.netty.GetServer;
import com.zhiliao.service.TeService;
import com.zhiliao.service.merchants_manage.MerchantsManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.channels.Channel;
import java.util.List;

/**
 * 测试类
 * @author Mr.Zhong
 * @create2019-07-29 12:19
 */
@Controller
public class Te01 {

    @Autowired
    TeService teService;

    @Autowired
    MerchantsManageService merchantsManageService;


    private List<Channel> channellist;

    @RequestMapping("sql")
    public String sqlArr() {

        System.out.println(teService.getAll().getBusinessName());

        return "ok";
    }

    @RequestMapping("sqlList")
    public String sqlList() throws Exception{
        System.out.println(merchantsManageService.selectByExample().get(0).getName());
        return "ok";
    }

    @RequestMapping("telist")
    public void telists(){
        System.out.println("size:"+GetServer.getInitialize().getObjectList().size());
        if(GetServer.getInitialize().getObjectList().size()!=0)
        GetServer.getInitialize().getObjectList().get(0).writeAndFlush("BigBang");
    }


    @RequestMapping("memberlists")
    public String memberlist(){
        return "member-list";
    }



}
