package com.zhiliao.controller;

import com.zhiliao.pojo.WlyyUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 启动器
 *
 * @author Mr.Zhong
 * @create2019-07-29 10:55
 */
@Controller
public class IndexServer {

    /**
     * 跳转到登陆页面
     *
     * @return
     */
    @RequestMapping("ToindexArr")
    public String indexArr() {
        return "/index1";
    }

    /**
     * 登陆后跳转
     *
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("instance")
    public String indexTo(HttpSession session) throws Exception {
        WlyyUser wlyyUser = (WlyyUser) session.getAttribute("user");
        if (wlyyUser != null)
            return "/index";
//        else return "redirect:/login.arr";
        else return "/index1";
    }

    /**
     * 跳转到菜单首页
     *
     * @return
     */
    @RequestMapping("welcome")
    public String login() {
        return "/welcome";
    }

    @RequestMapping("future")
    public String future() {
        return "/future";
    }

}
