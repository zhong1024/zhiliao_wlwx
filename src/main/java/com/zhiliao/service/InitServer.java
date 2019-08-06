package com.zhiliao.service;

import com.zhiliao.netty.GetServer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 服务管理实现类
 *
 * @author Mr.Zhong
 * @create2019-08-06 9:16
 */

@Component
@Lazy(value = false)
public class InitServer {

    /**
     * 初始化服务端
     */
    @PostConstruct
    public void init() {
        new Thread(() -> {
//            server servers = new server();
//            servers.initServer(null);
            GetServer.getInstance().initServer(null);
        }).start();
    }

    /**
     * 关闭服务时执行
     */
    @PreDestroy
    public void destroy() {
        System.out.println("############关闭服务#############");
    }


}
