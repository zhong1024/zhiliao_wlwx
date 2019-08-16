package com.zhiliao.netty;


import com.zhiliao.netty.servers.Server;

/**
 * @author Mr.Zhong
 * @create2019-07-29 11:30
 */
public class GetServer {

    private static Server servers;

    private static Initialize initialize;

    private static GetServer getServer;

    private GetServer(){}

    public static synchronized GetServer getServer(){
        if(getServer == null){
            getServer = new GetServer();
        }
        return getServer;
    }

    public static synchronized Server getInstance(){
        if(servers == null){
            servers = new Server();
        }
        return servers;
    }

    public static synchronized Initialize getInitialize(){
        if(initialize == null){
            initialize = new Initialize();
        }
        return initialize;
    }

}
