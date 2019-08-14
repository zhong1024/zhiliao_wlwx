package com.zhiliao.controller;

import com.zhiliao.pojo.WlyyUser;
import com.zhiliao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Zhong
 * @create2019-08-13 16:08
 */
@Controller
public class UserController {


    @Autowired
    UserService userService;

    /**
     * 跳转到登陆页面
     *
     * @param name
     * @return
     */
    @RequestMapping("login")
    public String login(String name) {
        return "/login";
    }

    /**
     * 登陆操作
     *
     * @param name 用户名
     * @param password 密码
     * @param session
     * @return
     */
    @RequestMapping("loginInit")
    @ResponseBody
    public Map<String, Object> loginInit(String name, String password, HttpSession session) {
        WlyyUser wlyyUser = new WlyyUser();
        wlyyUser.setName(name);
        wlyyUser.setPassword(password);
        WlyyUser wlyyUsers = userService.login(wlyyUser);
        session.setAttribute("user", wlyyUsers);
        Map<String, Object> map = new HashMap<>();
        map.put("user", wlyyUsers);
        return map;
    }


}
