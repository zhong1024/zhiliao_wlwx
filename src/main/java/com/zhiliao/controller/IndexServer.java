package com.zhiliao.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 启动器
 *
 * @author Mr.Zhong
 * @create2019-07-29 10:55
 */
@Controller
public class IndexServer {

    @RequestMapping("indexArr")
    public String indexArr() throws Exception {
        return "/index1";
    }

    @RequestMapping("instance")
    public String indexTo() {
        return "/index";
    }


    @RequestMapping("welcome")
    public String login() {
        return "/welcome";
    }

    @RequestMapping("future")
    public String future(){
        return "/future";
    }

}
